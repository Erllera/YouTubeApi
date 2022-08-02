package com.geektech.testing.youtube.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.testing.youtube.base.BaseViewModel
import com.geektech.testing.youtube.data.model.Playlist
import com.geektech.testing.youtube.network.repo.Repository

class PlaylistViewModel : BaseViewModel() {
    private val repo = Repository()
    private val _playlist = MutableLiveData<Playlist>()
    private val _localPlaylist = MutableLiveData<Boolean>()
    private val _result = MutableLiveData<Boolean>()

    val setPlaylist = _playlist.switchMap {
        repo.setPlaylist(it)
    }

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }

    fun getPlaylist() {
        _result.value = true
    }

    val getLocalPlaylist = _localPlaylist.switchMap {
        repo.getLocalPlaylist()
    }

    fun getLocalPlaylist() {
        _localPlaylist.value = true
    }

    fun setPlaylist(playlist: Playlist) {
        _playlist.value = playlist
    }

}