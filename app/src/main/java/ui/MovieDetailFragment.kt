package ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nazlicanterliksiz.movieapp.R
import com.nazlicanterliksiz.movieapp.databinding.FragmentDetailsMovieBinding
import data.MovieModel

class DetailsMovie : Fragment() {

    private lateinit var binding: FragmentDetailsMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsMovieBinding.inflate(layoutInflater)
        return binding.root
    }
    /*
    val intent = Intent
    val movieModel = intent.getSerializableExtra("movieModel") as MovieModel
    binding.moviePathImageView.text = movieModel.posterPath
    binding.movieTitleText.text = movieModel.originalTitle
    binding.movieVoteCountText.text = movieModel.voteCount
    binding.movieOverviewText.text = movieModel.overview
     */
}