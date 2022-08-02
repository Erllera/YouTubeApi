package com.geektech.testing.youtube.network.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.testing.youtube.App
import com.geektech.testing.youtube.data.domain.Resources
import com.geektech.testing.youtube.data.model.Playlist
import com.geektech.testing.youtube.network.RetrofitClient
import kotlinx.coroutines.Dispatchers

class Repository() {

    private val apiService = RetrofitClient.create()
    fun getPlaylist(): LiveData<Resources<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resources.loading())
        val result = apiService.getPlaylist()
        if (result.isSuccessful) {
            emit(Resources.success(result.body()))
        } else {

/*            val jObjError = result.errorBody()?.string()
            val gson = Gson()
            val data = gson.fromJson(jObjError, ErrorResponse::class.java)*/
            emit(Resources.error(result.errorBody()?.string()))
        }
    }

    fun setPlaylist(playlist: Playlist): LiveData<Resources<Boolean>> = liveData(Dispatchers.IO) {
        emit(Resources.loading())
        App.db.dao().insert(playlist)
        emit(Resources.success(true))
    }


    fun getLocalPlaylist(): LiveData<Resources<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resources.loading())
        val result = App.db.dao().getPlaylist()
        emit(Resources.success(result))
    }
}