package ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.MovieAdapter
import com.nazlicanterliksiz.movieapp.databinding.ActivityMainBinding
import data.MovieModel
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.themoviedb.org/3/movie/popular?api_key=79dc453ffcec8a0d438a6507908916c8
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val BASE_URL = "https://api.themoviedb.org/"
    private var movieModel: MovieModel? = null
    private var movieAdapter: MovieAdapter? = null
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        //binding.recyclerView2.layoutManager = layoutManager


    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        job = CoroutineScope(Dispatchers.IO).launch {
            //val response = retrofit.getData()


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}