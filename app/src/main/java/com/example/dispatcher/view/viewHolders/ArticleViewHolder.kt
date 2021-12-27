package com.example.dispatcher.view.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.dispatcher.databinding.CardFragmentBinding
import com.example.dispatcher.model.Article
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ArticleViewHolder(private val binding: CardFragmentBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        Picasso.get().load(article.urlToImage).into(binding.image)

        fun getFormattedDate(): String{
            val originalDateFormat = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date = LocalDate.parse(article.publishedAt, originalDateFormat)
            val dateFormatter = DateTimeFormatter
                .ofPattern(
                    "EEEE MMM d, yyyy",
                    Locale(Locale.getDefault().country)
                )
            return date.format(dateFormatter)
        }

        if (!article.publishedAt.isNullOrEmpty()) binding.date.text = getFormattedDate()
        binding.title.text = article.title
        binding.author.text = article.author
        binding.body.text = article.description
    }
}