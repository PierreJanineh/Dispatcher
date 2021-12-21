package com.example.dispatcher.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.dispatcher.ui.components.article.ArticleBaseFragment

class ViewExtensions {
    /**
     * Displays a Toast with the given text String in any BaseFragment.
     * @param text String of the text we wish toast about.
     */
    fun ArticleBaseFragment.displayToast(text: String) {
        activity?.let {
            Toast.makeText(it, text, Toast.LENGTH_LONG).show()
            Log.d("VIEW_EXTENSIONS", "displayToast: ")
        }
    }

    /**
     * Shows/Hides any View.
     * @param show Boolean to show/hide.
     */
    fun View.showView(show: Boolean){
        this.isVisible = show
    }
}