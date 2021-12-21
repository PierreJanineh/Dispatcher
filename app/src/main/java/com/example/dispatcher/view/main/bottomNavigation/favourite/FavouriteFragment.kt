package com.example.dispatcher.view.main.bottomNavigation.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dispatcher.databinding.FragmentFavouriteBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.FavouriteViewModel

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>() {

    private lateinit var favouriteViewModel: FavouriteViewModel

    override fun attachBinding(
        list: MutableList<FragmentFavouriteBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentFavouriteBinding.inflate(layoutInflater))
    }

    override fun setup() {
        favouriteViewModel =
            ViewModelProvider(this).get(FavouriteViewModel::class.java)
    }

}