package com.example.dispatcher.ui.base

import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import com.example.dispatcher.R
import com.example.dispatcher.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun setup() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.home_header)

        withBinding {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, MainFragment()).commit()
        }
    }

    override fun attachBinding(
        list: MutableList<ActivityMainBinding>,
        layoutInflater: LayoutInflater
    ) {
        list.add(ActivityMainBinding.inflate(layoutInflater))
    }
}