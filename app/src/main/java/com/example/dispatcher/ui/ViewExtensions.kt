package com.example.dispatcher.ui

import android.view.View
import androidx.core.view.isVisible

class ViewExtensions {
    /**
     * Shows/Hides any View.
     * @param show Boolean to show/hide.
     */
    fun View.showView(show: Boolean){
        this.isVisible = show
    }
}