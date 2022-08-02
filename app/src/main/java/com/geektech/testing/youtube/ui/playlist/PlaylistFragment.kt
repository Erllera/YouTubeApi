package com.geektech.testing.youtube.ui.playlist

import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geektech.testing.databinding.FragmentPlaylistBinding
import com.geektech.testing.youtube.adapter.PlaylistAdapter
import com.geektech.testing.youtube.base.BaseFragment
import com.geektech.testing.youtube.data.domain.Resources

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {
    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun viewBinding(layoutInflater: LayoutInflater): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(layoutInflater)
    }


    override fun initView() {
        viewModel.getPlaylist()
        viewModel.playlist.observe(viewLifecycleOwner) {
            viewModel.progress.value = it.status == Resources.Status.LOADING
            when (it.status) {
                Resources.Status.SUCCESS -> {
                    it.data?.let { it1 -> viewModel.setPlaylist(it1) }
                }
                Resources.Status.ERROR -> {

                }
            }
        }
        //Set and get local playlist
        viewModel.setPlaylist.observe(viewLifecycleOwner) { it ->
            viewModel.getLocalPlaylist()
            if (it.status == Resources.Status.SUCCESS && it.data == true) {
                viewModel.getLocalPlaylist.observe(viewLifecycleOwner) {
                    if (it.status == Resources.Status.SUCCESS) {
                        adapter = it.data?.let { it1 -> PlaylistAdapter(it1) }!!
                        binding.recyclerPlaylist.adapter = adapter
                    }
                }
            }
        }

        //Visibility progress bar
        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }

    }

    override fun initClick() {
    }


}