package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nazlicanterliksiz.movieapp.databinding.FragmentHomeBinding
import data.MovieAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by lazy { HomeViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movieModelList
        observe()
    }

    private fun observe() {
        viewModel.movieModelList.observe(viewLifecycleOwner) {
            binding.movieRV.adapter = MovieAdapter(it, onItemClickListener = { id ->
                //val intent = Intent(binding.root.context,DetailsMovie::class.java)
                //binding.root.context.startActivity(intent)
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment2(
                        id
                    )
                )
            })
        }
    }
}