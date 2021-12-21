package com.example.dispatcher.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dispatcher.R
import com.example.dispatcher.databinding.CardFragmentBinding
import com.example.dispatcher.view.base.BaseFragment

class CardFragment: BaseFragment<CardFragmentBinding>() {
    override fun attachBinding(
        list: MutableList<CardFragmentBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, CardFragmentBinding.inflate(layoutInflater))
    }

    override fun setup() {
        withBinding {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.image, ImageFragment())?.commit()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.title, TitleFragment())?.commit()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.author, AuthorFragment())?.commit()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.body, BodyFragment())?.commit()
        }
    }
}