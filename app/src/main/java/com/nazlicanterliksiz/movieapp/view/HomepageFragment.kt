package com.nazlicanterliksiz.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.nazlicanterliksiz.adapter.MovieAdapter
import com.nazlicanterliksiz.movieapp.databinding.FragmentHomePageBinding

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    private val viewModel : HomepageViewModel by lazy { HomepageViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovies()
        observe()
    }

    private fun observe(){
        viewModel.movie.observe(viewLifecycleOwner){
            binding.movieRV.adapter = MovieAdapter(it){

            }

        }
    }
}