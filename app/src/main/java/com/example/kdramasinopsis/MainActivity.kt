package com.example.kdramasinopsis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDramas: RecyclerView
    private val list = ArrayList<Drama>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDramas = findViewById(R.id.rv_dramas)
        rvDramas.setHasFixedSize(true)

        list.addAll(getListDramas())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //mendapatkan list
    private fun getListDramas(): ArrayList<Drama> {

        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataCast = resources.getStringArray(R.array.data_cast)
        val dataEpisodes = resources.getStringArray(R.array.data_episodes)
        val dataNetwork = resources.getStringArray(R.array.data_network)
        val dataSinopsis = resources.getStringArray(R.array.data_sinopsis)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listDrama = ArrayList<Drama>()
        for (i in dataTitle.indices) {
            val drama = Drama(dataTitle[i], dataCast[i], dataEpisodes[i], dataNetwork[i], dataSinopsis[i], dataPhoto.getResourceId(i, -1),)
            //val drama = Drama(dataTitle[i], dataEpisodes[i], dataSinopsis[i], dataPhoto.getResourceId(i, -1))
            listDrama.add(drama)
        }
        return listDrama
    }

    //menampilkan list
    private fun showRecyclerList() {
        rvDramas.layoutManager = LinearLayoutManager(this)
        val listDramaAdapter = ListDramaAdapter(list)
        rvDramas.adapter = listDramaAdapter

        listDramaAdapter.setOnItemClickCallback(object : ListDramaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Drama) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("drama_data", data)
                startActivity(intent)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}