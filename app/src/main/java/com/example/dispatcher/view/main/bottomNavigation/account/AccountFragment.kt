package com.example.dispatcher.view.main.bottomNavigation.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dispatcher.databinding.FragmentAccountBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.AccountViewModel

class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    private val accountViewModel: AccountViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<FragmentAccountBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentAccountBinding.inflate(layoutInflater))
    }

    override fun setup() {

    }
}