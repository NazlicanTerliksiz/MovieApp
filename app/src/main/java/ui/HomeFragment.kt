package ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import data.MovieAdapter
import com.nazlicanterliksiz.movieapp.databinding.FragmentHomePageBinding

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

<<<<<<< HEAD
    private val viewModel : HomeViewModel by lazy { HomeViewModel() }
=======
    private val viewModel: HomepageViewModel by lazy { HomepageViewModel() }
>>>>>>> origin/master

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movieModelList
        observe()
    }

<<<<<<< HEAD
    private fun observe(){
        viewModel.movieModelList.observe(viewLifecycleOwner){
            binding.movieRV.adapter = MovieAdapter(it, onItemClickListener = {
                findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToDetailsMovieFragment("","",""))
            })
=======
    private fun observe() {
        viewModel.movieModelList.observe(viewLifecycleOwner) {
            binding.movieRV.adapter = MovieAdapter(it, onItemClickListener = {
                //val intent = Intent(binding.root.context,DetailsMovie::class.java)
                //binding.root.context.startActivity(intent)
                // CALL NAVIGATION METHOD
            })

>>>>>>> origin/master
        }
    }
}