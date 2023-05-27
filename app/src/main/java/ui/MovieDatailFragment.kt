package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nazlicanterliksiz.movieapp.databinding.FragmentDetailMovieBinding
import com.squareup.picasso.Picasso

class MovieDatailFragment : Fragment() {

    private lateinit var binding: FragmentDetailMovieBinding
    private val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500"
    private val args: MovieDatailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMovieBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(BASE_IMG_URL + args.posterPath).into(binding.moviePathImageView)

        binding.apply {
            movieTitleText.text = args.originalTitle.toString()
            movieVoteAverageText.text = args.voteAverage.toString()
            movieVoteCountText.text = args.voteCount.toString()
            movieOverviewText.text = args.overview.toString()
        }
    }
}
/*
val intent = Intent
val movieModel = intent.getSerializableExtra("movieModel") as MovieModel
binding.moviePathImageView.text = movieModel.posterPath
binding.movieTitleText.text = movieModel.originalTitle
binding.movieVoteCountText.text = movieModel.voteCount
binding.movieOverviewText.text = movieModel.overview
 */