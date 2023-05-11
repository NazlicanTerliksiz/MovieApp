package com.nazlicanterliksiz.movieapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.nazlicanterliksiz.movieapp.service.MovieRetrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomepageViewModel : ViewModel() {

    private var job: Job? = null

    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel>
        get() = _movie

    fun getMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = MovieRetrofit.retrofitService.getMovie()
            if (response.isSuccessful) {
                response.body()?.let {movieModel ->
                    println("deneme $movieModel")
                    _movie.postValue(movieModel)
                }
            }
        }
    }

}

