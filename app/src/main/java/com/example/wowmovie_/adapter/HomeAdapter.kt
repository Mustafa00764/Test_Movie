package com.example.wowmovie_.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wowmovie_.R
import com.example.wowmovie_.model.MainModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.CollectionViewHolder>() {

    private val collection = ArrayList<MainModel>()

    fun submitList(collection: ArrayList<MainModel>) {
        this.collection.clear()
        this.collection.addAll(collection)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_ludshie_films, parent, false)
        return CollectionViewHolder(view)
    }

    override fun getItemCount() = collection.size


    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {

        holder.apply {
            val collection = collection[position]
            tvGenreMovie.text = collection.title
            rvMovieChild.adapter = MovieAdapter(collection.movieModels)

        }
    }

    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvGenreMovie = itemView.findViewById<TextView>(R.id.tvGenreMovie)
        val rvMovieChild = itemView.findViewById<RecyclerView>(R.id.rvMovieChild)
    }
}