package com.geektech.testing.youtube.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    protected abstract fun viewBinding(layoutInflater: LayoutInflater): VB
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = viewBinding(layoutInflater)
        return binding.root
    }

    abstract fun initView()
    abstract fun initClick()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClick()
    }


}