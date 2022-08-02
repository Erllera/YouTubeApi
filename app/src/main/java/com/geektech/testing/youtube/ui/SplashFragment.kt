package com.geektech.testing.youtube.ui

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.geektech.testing.R
import com.geektech.testing.databinding.FragmentSplashBinding
import com.geektech.testing.youtube.base.BaseFragment
import com.geektech.testing.youtube.base.BaseViewModel

class SplashFragment() : BaseFragment<FragmentSplashBinding, BaseViewModel>() {
    private lateinit var navController: NavController
    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this)[BaseViewModel::class.java]
    }

    override fun viewBinding(layoutInflater: LayoutInflater): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initView() {
        navController = NavHostFragment.findNavController(this)
        with(binding) {
            logo.alpha = 0f
            logo.animate().setDuration(1500).alpha(1f).withEndAction {
                navController.navigate(R.id.splashToPlaylist)
            }
        }
    }

    override fun initClick() {
    }


}