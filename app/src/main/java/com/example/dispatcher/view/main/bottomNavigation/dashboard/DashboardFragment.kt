package com.example.dispatcher.view.main.bottomNavigation.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dispatcher.model.Article
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dispatcher.databinding.FragmentDashboardBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.DashboardViewModel

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<FragmentDashboardBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentDashboardBinding.inflate(layoutInflater))
    }

    override fun setup() {
        withBinding {
            val adapter = ArticleAdapter()
            val layoutManager = LinearLayoutManager(requireContext())
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter

            dashboardViewModel.articles.observe(requireActivity(), {
                it?.let {
                    adapter.submitList(it as MutableList<Article>)
                }
            })
        }
    }
}