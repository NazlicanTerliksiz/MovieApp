package data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.squareup.picasso.Picasso


class MovieAdapter(private val movieList: MovieModel, val onItemClickListener: ((Int) -> Unit)) :
    RecyclerView.Adapter<MovieAdapter.RowHolder>() {

    inner class RowHolder(private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Result) {
            binding.apply {
                movieNameText.text = movie.originalTitle
                val url = "https://image.tmdb.org/t/p/w500"
                Picasso.get().load(url + movie.posterPath).into(movieImageView)
                root.setOnClickListener {
                    onItemClickListener.invoke(movie.id)
                }
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
