package com.example.dispatcher.view.main.bottomNavigation.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dispatcher.databinding.FragmentFavouriteBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.FavouriteViewModel

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>() {

    private val favouriteViewModel: FavouriteViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<FragmentFavouriteBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentFavouriteBinding.inflate(layoutInflater))
    }

    override fun setup() {

    }

}