package com.geektech.testing.youtube.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 1,
    val etag: String? = null,
    var items: List<Item?>? = null,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo? = null
)