package com.example.dispatcher.view.main

import android.view.LayoutInflater
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dispatcher.R
import com.example.dispatcher.view.base.BaseActivity
import com.example.dispatcher.databinding.ActivityMainBinding
import com.example.dispatcher.view.fragments.SplashScreenFragmentDirections
import com.example.dispatcher.viewmodel.AuthenticationViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    val viewModel: AuthenticationViewModel by viewModels()

    override fun setup() {
        setupActionBar()

        displaySplashScreen()
    }

    override fun attachBinding(
        list: MutableList<ActivityMainBinding>,
        layoutInflater: LayoutInflater
    ) {
        list.add(ActivityMainBinding.inflate(layoutInflater))
    }

    private fun setupActionBar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.home_header)

        supportActionBar?.hide()
    }

    private fun displaySplashScreen() {
        this.withBinding {
            this.root.setBackgroundResource(R.color.primary_color)

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment)
            val navController = (navHostFragment as NavHostFragment).navController

            placeMainFragment(navController)
        }
    }

    private fun placeMainFragment(navController: NavController) {
        Handler(Looper.getMainLooper()).postDelayed({
            var action = SplashScreenFragmentDirections.actionSplashScreenToLoginFragment()

            if (viewModel.isUserSignedIn())
                action = SplashScreenFragmentDirections.actionSplashScreenToMainFragment()

            navController.navigate(action)

            this.withBinding {
                this.root.setBackgroundResource(R.color.on_secondary_color)
            }

        }, 3000)
    }
}