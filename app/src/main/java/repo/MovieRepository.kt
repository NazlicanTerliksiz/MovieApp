package repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nazlicanterliksiz.movieapp.data.MovieRetrofit
import com.nazlicanterliksiz.movieapp.dto.MovieModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieRepository {

    private var job: Job? = null

    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel>
        get() = _movie

    init {
        getMovies()
    }

    //önce kitapları retrofitten çekildi
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
    //sonra bu kitapları getirmek için bir fonksiyon yazıldı
    fun getMov() : MutableLiveData<MovieModel>{
        return _movie
    }
}