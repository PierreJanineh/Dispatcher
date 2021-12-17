package com.example.dispatcher.ui.base.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dispatcher.ui.base.BaseFragment
import com.example.dispatcher.databinding.ArticleFragmentBinding
import com.example.dispatcher.model.Article

abstract class ArticleBaseFragment: BaseFragment<ArticleFragmentBinding>() {

    lateinit var articleList: ArrayList<Article>

    override fun attachBinding(
        list: MutableList<ArticleFragmentBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, ArticleFragmentBinding.inflate(layoutInflater))
    }

    override fun setup() {
        initArticleList()
    }

    private fun initArticleList() {
        articleList = arrayListOf(
            Article(
                "Facebook finally has live chat support for people who are locked out of their accounts",
                null,
                "Richard Lawler",
                "For the first time, Facebook is testing live chat agents for English-speaking users who have been locked out of their accounts. The updated support feature comes along with other changes to help creators manage their pages."
            ),
            Article(
                "How to Use Keyword Clustering to Seamlessly Optimize Your SEO Content",
                null,
                "Zoe Ashbridge",
                "Keyword clustering is the SEO tactic to use if you want to seamlessly optimize your SEO content and streamline your workflow at the same time. The best part? It’s fairly simple, and SERPs give you all the information you need to make an informed decision on e…"
            ),
            Article(
                "Pixel Launcher update saves you time finding those hidden screenshots",
                null,
                "Jay Bonggolto",
                "The launcher now lets you quickly search for the screenshot folder in Google Photos.\\n\\nWhat you need to know\\n\\n\\nThe Pixel Launcher now includes a new feature that allows you to quickly search for screenshots stored in Google Photos.\\nAs usual, the new capability…"
            )
        )
    }

}