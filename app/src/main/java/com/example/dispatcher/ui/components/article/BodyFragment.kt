package com.example.dispatcher.ui.components.article

import com.example.dispatcher.R
import com.example.dispatcher.databinding.ArticleFragmentBinding

class BodyFragment: ArticleBaseFragment() {
    override fun setup() {
        super.setup()

        withBinding {
            configureTextView(this)
        }
    }

    private fun configureTextView(binding: ArticleFragmentBinding) {
        binding.textView.text = articleList[0].body?.take(2)

        binding.textView.textSize = 14F
//            binding.textView.lineHeight = 16 //looks bad on current font
        binding.textView.setTextColor(resources.getColor(R.color.body_fragment_text_color, null))
    }
}