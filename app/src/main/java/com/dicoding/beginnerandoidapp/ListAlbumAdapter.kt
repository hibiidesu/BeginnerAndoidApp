package com.dicoding.beginnerandoidapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.beginnerandoidapp.databinding.ItemRowAlbumBinding

class ListAlbumAdapter(private val listAlbum: ArrayList<Albums>) : RecyclerView.Adapter<ListAlbumAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) =listAlbum[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_ALBUM, listAlbum.get(holder.adapterPosition))
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int =  listAlbum.size

    class ListViewHolder(var binding: ItemRowAlbumBinding) : RecyclerView.ViewHolder(binding.root)
}