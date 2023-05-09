package com.nazlicanterliksiz.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.adapter.MovieAdapter
import com.nazlicanterliksiz.movieapp.R
import com.nazlicanterliksiz.movieapp.databinding.ActivityMainBinding
import com.nazlicanterliksiz.movieapp.databinding.FragmentHomePageBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import kotlinx.coroutines.Job

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    private lateinit var viewModel: HomepageViewModel

    private val viewModel:HomepageViewModel by lazy { HomepageViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movie.observe(viewLifecycleOwner,{
            MovieAdapter.RowHolder()})
        
        binding.movieRV.layoutManager= GridLayoutManager(activity,2)
        binding.movieRV.adapter = MovieAdapter()


    }
}