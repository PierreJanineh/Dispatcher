package com.example.dispatcher.view.viewAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dispatcher.databinding.CardFragmentBinding
import com.example.dispatcher.model.Article
import com.example.dispatcher.view.viewHolders.ArticleViewHolder

internal class ArticleAdapter(val list: LiveData<ArrayList<Article>>, private val lifecycleOwner: LifecycleOwner) : ListAdapter<Article, ArticleViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        list.observe(lifecycleOwner, {
            it?.let {
                holder.bind(it[position])
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = CardFragmentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Article> =
            object : DiffUtil.ItemCallback<Article>() {
                override fun areItemsTheSame(
                    oldArticle: Article, newArticle: Article
                ): Boolean {
                    return oldArticle.title === newArticle.title
                }

                override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                    return oldItem == newItem
                }
            }
    }
}