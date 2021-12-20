package com.example.dispatcher.ui.components.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dispatcher.databinding.ImageFragmentBinding
import com.example.dispatcher.ui.base.BaseFragment

class ImageFragment: BaseFragment<ImageFragmentBinding>() {
    override fun attachBinding(
        list: MutableList<ImageFragmentBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, ImageFragmentBinding.inflate(layoutInflater))
    }

    override fun setup() {
        withBinding {
//            image.setImageResource() //set Image after fetching from API
        }
    }

}