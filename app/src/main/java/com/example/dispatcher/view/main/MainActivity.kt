package com.example.dispatcher.view.main

import android.view.LayoutInflater
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.ActionBar
import com.example.dispatcher.R
import com.example.dispatcher.view.base.BaseActivity
import com.example.dispatcher.databinding.ActivityMainBinding
import com.example.dispatcher.view.fragments.SplashScreenFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
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

            val trans = supportFragmentManager.beginTransaction()
            trans.runOnCommit {
                placeMainFragment()
            }
            trans.add(R.id.frame_layout, SplashScreenFragment()).commit()
        }
    }

    private fun placeMainFragment() {
        val mainFragment = MainFragment()

        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, mainFragment)
                .commit()
            supportActionBar?.show()

            this.withBinding {
                this.root.setBackgroundResource(R.color.on_secondary_color)
            }

        }, 3000)
    }
}