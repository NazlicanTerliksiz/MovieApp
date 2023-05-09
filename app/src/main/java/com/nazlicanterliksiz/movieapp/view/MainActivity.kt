package com.nazlicanterliksiz.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nazlicanterliksiz.movieapp.databinding.ActivityMainBinding

//https://api.themoviedb.org/3/movie/popular?api_key=79dc453ffcec8a0d438a6507908916c8
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}