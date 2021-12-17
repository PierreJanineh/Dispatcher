package com.example.dispatcher.ui.base.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dispatcher.ui.base.BaseFragment
import com.example.dispatcher.databinding.ArticleFragmentBinding

abstract class ArticleBaseFragment: BaseFragment<ArticleFragmentBinding>() {
    override fun attachBinding(
        list: MutableList<ArticleFragmentBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, ArticleFragmentBinding.inflate(layoutInflater))
    }
}