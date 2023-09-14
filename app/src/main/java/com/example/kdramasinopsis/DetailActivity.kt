package com.example.kdramasinopsis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity() : AppCompatActivity() {
    //Mengambil data dari activity dengan key
    companion object {
        const val EXTRA_DRAMA = "drama_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Mengambil objek Drama dari intent
        val drama = intent.getParcelableExtra<Drama>("drama_data")

        // Menampilkan nilai ke dalam layout
        val picImageView = findViewById<ImageView>(R.id.tv_item_pic)
        val titleTextView = findViewById<TextView>(R.id.tv_item_title)
        val castTextView = findViewById<TextView>(R.id.tv_item_cast)
        val episodesTextView = findViewById<TextView>(R.id.tv_item_episodes)
        val networkTextView = findViewById<TextView>(R.id.tv_item_network)
        val sinopsisTextView = findViewById<TextView>(R.id.tv_item_sinopsis)


        // Memeriksa apakah objek Drama tidak null
        if (drama != null) {
            picImageView.setImageResource(drama.photo)
            titleTextView.text = drama.title
            castTextView.text = drama.cast
            episodesTextView.text = drama.episodes
            networkTextView.text = drama.network
            sinopsisTextView.text = drama.sinopsis

        }
    }
}
