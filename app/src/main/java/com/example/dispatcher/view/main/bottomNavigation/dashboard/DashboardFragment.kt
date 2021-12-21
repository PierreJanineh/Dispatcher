package com.example.dispatcher.view.main.bottomNavigation.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dispatcher.databinding.FragmentDashboardBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.DashboardViewModel

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun attachBinding(
        list: MutableList<FragmentDashboardBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentDashboardBinding.inflate(layoutInflater))
    }

    override fun setup() {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
    }
}