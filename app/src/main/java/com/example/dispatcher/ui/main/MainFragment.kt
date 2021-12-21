package com.example.dispatcher.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dispatcher.R
import com.example.dispatcher.databinding.FragmentMainBinding
import com.example.dispatcher.ui.base.BaseFragment
import com.example.dispatcher.model.ArticlesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.dispatcher.model.network.apiControllers.ArticlesApiController

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun setup() {
        withBinding {
            setUpNavigation(this)
        }

        getArticles()
    }

    override fun attachBinding(
        list: MutableList<FragmentMainBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentMainBinding.inflate(layoutInflater))
    }

    private fun setUpNavigation(binding: FragmentMainBinding) {
        val bottomNavigationView = binding.navigation
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun getArticles() {
        ArticlesApiController()
            .getArticles(object: Callback<ArticlesResponse> {
                override fun onResponse(
                    call: Call<ArticlesResponse>,
                    response: Response<ArticlesResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("MainFragment", "onCreate.setup.getArticles: body ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            }, "k")
    }
}