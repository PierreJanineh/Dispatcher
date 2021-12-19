package com.example.dispatcher.ui.components.article

import com.example.dispatcher.R
import com.example.dispatcher.databinding.ArticleFragmentBinding

class AuthorFragment: ArticleBaseFragment() {
    override fun setup() {
        super.setup()

        withBinding {
            configureTextView(this)
        }
    }

    private fun configureTextView(binding: ArticleFragmentBinding) {
        binding.textView.text = articleList[0].author

        binding.textView.textSize = 14F
        binding.textView.lineHeight = 22
        binding.textView.letterSpacing = 0.25F
        binding.textView.setTextColor(resources.getColor(R.color.author_fragment_text_color, null))
    }
}