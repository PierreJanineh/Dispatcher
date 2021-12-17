package com.example.dispatcher.ui.base

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.example.dispatcher.R
import com.example.dispatcher.databinding.ActivityMainBinding
import com.example.dispatcher.ui.splashScreen.SplashScreenFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun setup() {
        displaySplashScreen()
    }

    override fun attachBinding(
        list: MutableList<ActivityMainBinding>,
        layoutInflater: LayoutInflater
    ) {
        list.add(ActivityMainBinding.inflate(layoutInflater))
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
        val mainFragment = MainFragment.newInstance()

        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, mainFragment)
                .commit()

            this.withBinding {
                this.root.setBackgroundResource(R.color.on_secondary_color)
            }

        }, 3000)
    }
}