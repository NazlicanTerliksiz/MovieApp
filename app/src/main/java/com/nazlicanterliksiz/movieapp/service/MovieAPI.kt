package com.nazlicanterliksiz.movieapp.service

import com.nazlicanterliksiz.movieapp.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieAPI {

    @GET("3/movie/popular?api_key=79dc453ffcec8a0d438a6507908916c8")
    fun getData(): Call<MovieModel>
}