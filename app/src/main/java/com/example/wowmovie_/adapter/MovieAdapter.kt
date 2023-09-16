package com.example.wowmovie_.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wowmovie_.R
import com.example.wowmovie_.model.ResultsItem
import com.example.wowmovie_.model.ResultsItems

class MovieAdapter( private val movieModel: ArrayList<ResultsItem>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    //    private val collection: ArrayList<ResultsItem> = ArrayList()
    var itemClick: ((Int) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_mini, parent, false)
        return MovieViewHolder(view)
    }


    override fun getItemCount() = movieModel.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.apply {
            val movie = movieModel[position]
            Glide.with(ivMovieImage).load("https://image.tmdb.org/t/p/w500${movie.posterPath}").into(ivMovieImage)
            tvMovieName.text = movie.originalTitle
            tvBall.text = movie.voteAverage.toString()
            tvYear.text = movie.releaseDate
//            itemClick?.invoke(position)

            llItemMovieMini.setOnClickListener {

            }
        }


    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivMovieImage = itemView.findViewById<ImageView>(R.id.iv_movie_image)
        val llItemMovieMini = itemView.findViewById<LinearLayout>(R.id.ll_item_movie_mini)
        val tvMovieName = itemView.findViewById<TextView>(R.id.tv_movie_name)
        val tvBall = itemView.findViewById<TextView>(R.id.tv_ball)
        val tvYear = itemView.findViewById<TextView>(R.id.tv_movie_janr)


    }

}