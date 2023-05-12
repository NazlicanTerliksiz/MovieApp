package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.MovieModel
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

