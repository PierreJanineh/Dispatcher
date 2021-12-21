package com.example.dispatcher.view.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dispatcher.model.Article

class ArticleViewModel: ViewModel() {
    private val articleList: MutableLiveData<ArrayList<Article>> = MutableLiveData(arrayListOf(
        Article(
            "Facebook finally has live chat support for people who are locked out of their accounts",
            "https://www.reuters.com/pf/resources/images/reuters/reuters-default.png?d=66",
            "Richard Lawler",
            "For the first time, Facebook is testing live chat agents for English-speaking users who have been locked out of their accounts. The updated support feature comes along with other changes to help creators manage their pages.",
            null, null, null, null
        ),
        Article(
            "How to Use Keyword Clustering to Seamlessly Optimize Your SEO Content",
            "https://www.reuters.com/pf/resources/images/reuters/reuters-default.png?d=66",
            "Zoe Ashbridge",
            "Keyword clustering is the SEO tactic to use if you want to seamlessly optimize your SEO content and streamline your workflow at the same time. The best part? It’s fairly simple, and SERPs give you all the information you need to make an informed decision on e…",
            null, null, null, null
        ),
        Article(
            "Pixel Launcher update saves you time finding those hidden screenshots",
            "https://www.reuters.com/pf/resources/images/reuters/reuters-default.png?d=66",
            "Jay Bonggolto",
            "The launcher now lets you quickly search for the screenshot folder in Google Photos.\\n\\nWhat you need to know\\n\\n\\nThe Pixel Launcher now includes a new feature that allows you to quickly search for screenshots stored in Google Photos.\\nAs usual, the new capability…",
            null, null, null, null
        )
    ))

    fun getArticleList(): LiveData<ArrayList<Article>> {
        return articleList
    }
}