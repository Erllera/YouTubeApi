package com.geektech.testing.youtube.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.testing.databinding.ItemPlaylistBinding
import com.geektech.testing.youtube.data.model.Item
import com.geektech.testing.youtube.data.model.Playlist

class PlaylistAdapter(private val data: Playlist) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
    private var list = ArrayList<Playlist>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        data.items?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return data.items?.size ?: 0
    }

    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            binding.thumbnailPlaylist.load(item.snippet.thumbnails.maxres.url)
            binding.playlistName.text = item.snippet.title
            binding.playlistKind.text = item.kind
            binding.playlistSize.text = item.contentDetails.itemCount.toString() + " видео"
        }
    }

}