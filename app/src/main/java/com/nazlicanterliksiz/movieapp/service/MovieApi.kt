package com.nazlicanterliksiz.movieapp.service

import com.nazlicanterliksiz.movieapp.model.MovieModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.deezer.com/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MovieApi{
    @GET("genre")
    suspend fun getMovie(): Response<MovieModel>
}

object MovieRetrofit {
    val retrofitService: MovieApi by lazy { retrofit.create(MovieApi::class.java) }
}