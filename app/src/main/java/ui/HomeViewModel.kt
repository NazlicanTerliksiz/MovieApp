package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.MovieModel
import repo.MovieRepository

class HomeViewModel : ViewModel() {

    private val movieRepo = MovieRepository()
    var movieModelList = MutableLiveData<MovieModel>()

    init {
        getMovieFromRepo()
        movieModelList = movieRepo.getMov()
    }

    private fun getMovieFromRepo(){
        movieRepo.getMovies()
    }
}

