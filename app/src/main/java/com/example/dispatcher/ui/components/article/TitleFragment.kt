package com.example.dispatcher.ui.components.article

import android.graphics.Paint
import com.example.dispatcher.R
import com.example.dispatcher.databinding.ArticleFragmentBinding

class TitleFragment: ArticleBaseFragment() {
    override fun setup() {
        super.setup()

        withBinding {
            configureTextView(this)
        }
    }

    private fun configureTextView(binding: ArticleFragmentBinding) {
        binding.textView.text = articleList[0].title

        binding.textView.textSize = 18F
//            binding.textView.lineHeight = 21 //looks bad on current font
        binding.textView.paintFlags = Paint.FAKE_BOLD_TEXT_FLAG
        binding.textView.setTextColor(resources.getColor(R.color.title_fragment_text_color, null))
    }
}