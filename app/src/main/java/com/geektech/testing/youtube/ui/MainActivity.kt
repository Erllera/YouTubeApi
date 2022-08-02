package com.geektech.testing.youtube.ui

import android.view.LayoutInflater
import com.geektech.testing.databinding.ActivityMainBinding
import com.geektech.testing.youtube.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
    }

    override fun initClick() {
    }

}