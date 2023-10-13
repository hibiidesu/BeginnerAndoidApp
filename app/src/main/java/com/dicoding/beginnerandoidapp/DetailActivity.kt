package com.dicoding.beginnerandoidapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.beginnerandoidapp.databinding.ActivityDetailBinding

// TODO: Make a share function
// TODO: Apply more data types
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_ALBUM = "extra_album"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataAlbum = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Albums>(EXTRA_ALBUM, Albums::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Albums>(EXTRA_ALBUM)
        }

        if (dataAlbum != null) {
            Glide.with(this)
                .load(dataAlbum.photo)
                .into(binding.imageAlbum)
            binding.textAlbum.text = dataAlbum.name
            binding.textDescription.text = dataAlbum.description
            binding.layoutTracks.textTracks.text = dataAlbum.tracks
            binding.layoutArtist.textName.text = dataAlbum.artistName
            binding.layoutArtist.textDesc.text = dataAlbum.artistDesc
            Glide.with(this)
                .load(dataAlbum.artistPhoto)
                .into(binding.layoutArtist.imageArtist)
        }
    }
}