package data

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.squareup.picasso.Picasso
import ui.DetailsMovie


class MovieAdapter(private val movieList: MovieModel, val onItemClickListener: (() -> Unit)) :
    RecyclerView.Adapter<MovieAdapter.RowHolder>() {

    inner class RowHolder(private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {


        init {
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context,DetailsMovie::class.java)
                binding.root.context.startActivity(intent)
                onItemClickListener.invoke()
            }
        }
        fun bind(movie: Result) {
            binding.apply {
                movieNameText.text = movie.originalTitle
                val url = "https://image.tmdb.org/t/p/w500"
                Picasso.get().load(url + movie.posterPath).into(movieImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.results.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val movie = movieList.results[position]
        holder.bind(movie)

    }
}
