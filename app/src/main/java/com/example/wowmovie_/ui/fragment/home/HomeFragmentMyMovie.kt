package com.example.wowmovie_.ui.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wowmovie_.R
import com.example.wowmovie_.adapter.HomeAdapter
import com.example.wowmovie_.adapter.MovieAdapter
import com.example.wowmovie_.data.remote.TMDBClient
import com.example.wowmovie_.model.MainModel
import com.example.wowmovie_.model.Movies
import com.example.wowmovie_.model.ResultsItem
import com.example.wowmovie_.model.ResultsItems

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class HomeFragmentMyMovie : Fragment(R.layout.fragment_home_my_movie) {
    lateinit var movie: ArrayList<ResultsItem>

    lateinit var adapter: HomeAdapter

    //    lateinit var adapter: MovieAdapter
    lateinit var movies: ArrayList<MainModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        movie = ArrayList()
        movies = ArrayList()
        adapter = HomeAdapter()
//        val rvMovieChild = view.findViewById<RecyclerView>(R.id.rvMovieChild)
        val rvMain = view.findViewById<RecyclerView>(R.id.rvMain)
        rvMain.adapter = adapter
//        rvMovieChild.adapter = adapter
        fetchNowPlayingMovies()

    }


    private fun fetchNowPlayingMovies() {

        Log.d("@@@@@@", "fetchNowPlayingMovies: ")
        TMDBClient.api.getNowPlayingMovies().enqueue(object : Callback<Movies> {
            override fun onResponse(
                call: Call<Movies>,
                response: Response<Movies>
            ) {
                if (response.isSuccessful) {
                    movie.clear()
                    Log.d("@@@@@@", "onResponse: ${response.body()}")
                    response.body()?.results?.forEach {
                        movie.add(it)
                    }
                    movies.add(MainModel("Now Playing", movie))
                    adapter.submitList(movies)

                } else {
                    Log.d("@@@@@@", "onResponse:${response.code()} ")
                    Log.d("@@@@@@", "onResponse:${response.errorBody()} ")
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("@@@@@@", "onFailure:${t.localizedMessage} : ${t.message} : ${t.cause} ")
            }

        })
    }

    fun ludshiyFilm() {
//        movie = ArrayList()
//        val movies = ArrayList<MainModel>()
//        movies.add(MainModel("ggggg",movie))
    }

}