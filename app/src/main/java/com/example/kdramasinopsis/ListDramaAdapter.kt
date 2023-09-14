package com.example.kdramasinopsis

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDramaAdapter(private val listDrama: ArrayList<Drama>) : RecyclerView.Adapter<ListDramaAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_drama, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, cast, episodes, network, sinopsis, photo) = listDrama[position]

        holder.tvTitle.text = title
        holder.tvCast.text = cast
        holder.tvEpisodes.text = episodes
        holder.tvNetwork.text = network
        holder.tvSinopsis.text = sinopsis
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            onItemClickCallback.onItemClicked(listDrama[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Drama)
    }

    override fun getItemCount(): Int = listDrama.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvCast: TextView = itemView.findViewById(R.id.tv_item_cast)
        val tvEpisodes: TextView = itemView.findViewById(R.id.tv_item_episodes)
        val tvNetwork: TextView = itemView.findViewById(R.id.tv_item_network)
        val tvSinopsis: TextView = itemView.findViewById(R.id.tv_item_sinopsis)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}