package com.example.dispatcher.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dispatcher.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

}