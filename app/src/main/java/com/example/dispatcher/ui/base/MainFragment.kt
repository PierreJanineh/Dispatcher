package com.example.dispatcher.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dispatcher.R
import com.example.dispatcher.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun setup() {
        withBinding {
            setUpNavigation(this)
        }
    }

    override fun attachBinding(
        list: MutableList<FragmentMainBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(FragmentMainBinding.inflate(layoutInflater))
    }

    private fun setUpNavigation(binding: FragmentMainBinding) {
        val bottomNavigationView = binding.navigation
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
    }
}