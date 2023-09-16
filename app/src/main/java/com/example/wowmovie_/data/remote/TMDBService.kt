package com.example.wowmovie_.data.remote

import com.example.wowmovie_.model.Movies
import com.example.wowmovie_.model.ResultsItem
import com.example.wowmovie_.model.ResultsItems
import retrofit2.Call
import retrofit2.http.GET


interface TMDBService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(): Call<Movies>

}