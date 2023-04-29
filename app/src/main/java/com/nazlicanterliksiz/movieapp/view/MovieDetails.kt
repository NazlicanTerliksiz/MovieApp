package com.nazlicanterliksiz.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nazlicanterliksiz.movieapp.databinding.ActivityMainBinding
import com.nazlicanterliksiz.movieapp.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}