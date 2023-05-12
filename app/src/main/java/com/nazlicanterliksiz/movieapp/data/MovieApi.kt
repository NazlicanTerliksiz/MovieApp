package com.nazlicanterliksiz.movieapp.data

import com.nazlicanterliksiz.movieapp.dto.MovieModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MovieApi{
    @GET("3/movie/popular?api_key=79dc453ffcec8a0d438a6507908916c8")
    suspend fun getMovie(): Response<MovieModel>
}

object MovieRetrofit {
    val retrofitService: MovieApi by lazy { retrofit.create(MovieApi::class.java) }
}