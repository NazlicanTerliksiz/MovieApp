package com.nazlicanterliksiz.movieapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.adapter.MovieAdapter
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.nazlicanterliksiz.movieapp.service.MovieApi
import com.nazlicanterliksiz.movieapp.service.MovieRetrofit
import kotlinx.coroutines.*

class HomepageViewModel: ViewModel() {

    private var movieModels: MutableLiveData<MovieModel>? = null
    private var movieAdapter: MutableLiveData<MovieAdapter>?=null
    private var job: Job? = null

    private val _movie = MutableLiveData<MovieModel>()
    val movie : LiveData<MovieModel>
        get() = _movie


    init {
        getMovies()
    }

    private fun getMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getMovie()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    response.body()?.let { movieModel ->
                        movieModels = movieModel
                        movieModels?.let {
                            movieAdapter = MovieAdapter(movieModel) {
                                //CLICK IS HERE
                            }
                            binding.movieRV.adapter = movieAdapter
                        }
                    }
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}