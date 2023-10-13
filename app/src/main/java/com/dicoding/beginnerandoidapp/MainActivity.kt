package com.dicoding.beginnerandoidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.beginnerandoidapp.databinding.ActivityMainBinding

// TODO: Implement splash screens
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAlbums: RecyclerView
    private val list =ArrayList<Albums>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvAlbums = binding.rvAlbums
        rvAlbums.setHasFixedSize(true)

        list.addAll(getListAlbums())
        showRecyclerList()
    }

    private fun getListAlbums(): ArrayList<Albums> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataTrack = resources.getStringArray(R.array.data_track)
        val dataArtistName = resources.getStringArray(R.array.data_artist_name)
        val dataArtistPhoto = resources.getStringArray(R.array.data_artist_photo)
        val dataArtistDesc = resources.getStringArray(R.array.data_artist_desc)
        val listAlbum = ArrayList<Albums>()
        for (i in dataName.indices) {
            val album = Albums(dataName[i], dataDescription[i], dataPhoto[i], dataTrack[i], dataArtistName[i], dataArtistPhoto[i], dataArtistDesc[i])
            listAlbum.add(album)
        }
        return listAlbum
    }

    private fun showRecyclerList() {
        rvAlbums.layoutManager = LinearLayoutManager(this)
        val listAlbumAdapter = ListAlbumAdapter(list)
        rvAlbums.adapter = listAlbumAdapter
    }

}