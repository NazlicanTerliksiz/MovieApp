package com.nazlicanterliksiz.movieapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.adapter.MovieAdapter
import com.nazlicanterliksiz.movieapp.databinding.ActivityMainBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.nazlicanterliksiz.movieapp.service.MovieAPI
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.themoviedb.org/3/movie/popular?api_key=79dc453ffcec8a0d438a6507908916c8
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val BASE_URL = "https://api.themoviedb.org/"
    private var movieModels: MovieModel? = null
    private var movieAdapter: MovieAdapter? = null
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView2.layoutManager = layoutManager

        loadData()

    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getData()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    response.body()?.let { movieModel ->
                        movieModels = movieModel
                        movieModels?.let {
                            movieAdapter = MovieAdapter(movieModel) {
                                //CLICK IS HERE
                            }
                            binding.recyclerView2.adapter = movieAdapter
                        }
                    }
                }
            }
        }


        /*
        val service = retrofit.create(MovieAPI::class.java)
        val call = service.getData()
        call.enqueue(object: Callback<MovieModel>{
            override fun onResponse(
                call: Call<MovieModel>,
                response: Response<MovieModel>
            ) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        movieModels = it

                        movieModels?.let {
                            c
                        }

                        //for (movieModel: MovieModel in movieModels!!) {
                        //   println(movieModel.original_title) }
                    }
                }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
         */
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}