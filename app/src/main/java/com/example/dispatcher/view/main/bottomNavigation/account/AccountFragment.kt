package com.example.dispatcher.ui.main.bottomNavigation.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dispatcher.databinding.FragmentAccountBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.AccountViewModel

class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    private lateinit var accountViewModel: AccountViewModel

    override fun attachBinding(
        list: MutableList<FragmentAccountBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentAccountBinding.inflate(layoutInflater))
    }

    override fun setup() {
        accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)
    }
}