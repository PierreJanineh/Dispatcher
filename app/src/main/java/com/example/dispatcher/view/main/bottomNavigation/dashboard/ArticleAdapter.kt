package com.example.dispatcher.view.main.bottomNavigation.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dispatcher.R
import com.example.dispatcher.model.Article
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

internal class ArticleAdapter : ListAdapter<Article, ArticleAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.image)
        val date: TextView = view.findViewById(R.id.date)
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val body: TextView = view.findViewById(R.id.body)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)!!

        Picasso.get().load(article.urlToImage).into(holder.image)

        val originalDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date = LocalDate.parse(article.publishedAt, originalDateFormat)
        val dateFormatter = DateTimeFormatter.ofPattern("EEEE MMM d, yyyy", Locale(Locale.getDefault().country))

        if (!article.publishedAt.isNullOrEmpty()) holder.date.text = date.format(dateFormatter)
        if (!article.title.isNullOrEmpty()) holder.title.text = article.title
        if (!article.author.isNullOrEmpty()) holder.author.text = article.author
        if (!article.description.isNullOrEmpty()) holder.body.text = article.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_fragment, parent, false)
        return ViewHolder(view)
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