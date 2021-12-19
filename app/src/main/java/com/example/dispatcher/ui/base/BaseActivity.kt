package com.example.dispatcher.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB_CHILD : ViewBinding> : AppCompatActivity() {

    private var binding: VB_CHILD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout(layoutInflater))
        setup()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.binding = null
    }

    private fun getInflatedLayout(inflater: LayoutInflater): View {
        val tempList = mutableListOf<VB_CHILD>()
        attachBinding(tempList, inflater)
        this.binding = tempList[0]

        return binding?.root?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachBinding(list: MutableList<VB_CHILD>, layoutInflater: LayoutInflater)

    abstract fun setup()

    fun withBinding(block: (VB_CHILD.() -> Unit)?): VB_CHILD {
        val bindingAfterRunning:VB_CHILD? = binding?.apply { block?.invoke(this) }
        return bindingAfterRunning
            ?:  error("Accessing binding outside of lifecycle: ${this::class.java.simpleName}")
    }
}