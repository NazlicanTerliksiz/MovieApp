package com.nazlicanterliksiz.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlicanterliksiz.movieapp.dto.MovieModel
import com.nazlicanterliksiz.movieapp.data.MovieRetrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import repo.MovieRepository

class HomepageViewModel : ViewModel() {

    private val movierepo = MovieRepository()
    var movieModelList = MutableLiveData<MovieModel>()

    init {
        getMovieFromRepo()
        movieModelList = movierepo.getMov()
    }

    private fun getMovieFromRepo(){
        movierepo.getMovies()
    }
}

