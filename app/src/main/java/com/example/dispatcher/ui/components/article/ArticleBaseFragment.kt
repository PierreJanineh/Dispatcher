package com.example.dispatcher.ui.components.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dispatcher.ui.base.BaseFragment
import com.example.dispatcher.databinding.ArticleFragmentBinding
import com.example.dispatcher.model.Article

abstract class ArticleBaseFragment: BaseFragment<ArticleFragmentBinding>() {

    lateinit var articleList: ArrayList<Article>
    private val model: ArticleViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<ArticleFragmentBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, ArticleFragmentBinding.inflate(layoutInflater))
    }

    override fun setup() {
        model.getArticleList().observe(this, { articles ->
            articleList = articles
        })
    }

}