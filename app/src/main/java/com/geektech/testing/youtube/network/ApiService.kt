package com.geektech.testing.youtube.network

import com.geektech.testing.BuildConfig
import com.geektech.testing.youtube.data.model.Const
import com.geektech.testing.youtube.data.model.Playlist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String = Const.PART,
        @Query("channelId") channelId: String = Const.CHANNEL_ID,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Response<Playlist>
}