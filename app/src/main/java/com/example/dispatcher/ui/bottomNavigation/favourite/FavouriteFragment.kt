package com.example.dispatcher.ui.bottomNavigation.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dispatcher.databinding.FragmentFavouriteBinding
import com.example.dispatcher.ui.base.BaseFragment

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