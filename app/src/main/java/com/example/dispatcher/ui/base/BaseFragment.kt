package com.example.dispatcher.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB_CHILD : ViewBinding> : Fragment() {

    private var binding: VB_CHILD? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = getInflatedView(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.binding = null
    }

    private fun getInflatedView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): View {
        val tempList = mutableListOf<VB_CHILD>()
        attachBinding(tempList, inflater, container, attachToRoot)
        this.binding = tempList[0]
        return binding?.root
            ?: error("Please add your inflated binding class instance at 0th position in list")
    }

    abstract fun attachBinding(
        list: MutableList<VB_CHILD>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    )

    abstract fun setup()

    fun withBinding(block: (VB_CHILD.() -> Unit)?): VB_CHILD {
        val bindingAfterRunning:VB_CHILD? = binding?.apply { block?.invoke(this) }
        return bindingAfterRunning
            ?:  error("Accessing binding outside of lifecycle: ${this::class.java.simpleName}")
    }

}
