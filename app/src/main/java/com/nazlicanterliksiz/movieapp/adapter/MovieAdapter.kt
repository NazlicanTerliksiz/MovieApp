package com.nazlicanterliksiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList : MovieModel, private val listener : Listener)
    : RecyclerView.Adapter<MovieAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(movieModel: com.nazlicanterliksiz.movieapp.model.Result)
    }

    class RowHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.results.count()
    }

    // override fun onBindViewHolder(holder: RowHolder, position: Int) {
    //   holder.itemView.setOnClickListener {
    //       listener.onItemClick(movieList.results.get(position))
    //  }

     //   holder.binding.movieNameText.text = movieList.results.get(position).original_title
     //   Picasso.get().load(movieList.results.get(position).poster_path).into(movieImageView)
     //}
     override fun onBindViewHolder(holder: RowHolder, position: Int) {
         val movie = movieList.results.get(position)

         holder.binding.apply {
             movieNameText.text = movie.original_title
             val url = "https://image.tmdb.org/t/p/w500"
             Picasso.get().load(url + movie.poster_path).into(movieImageView)
         }
     }
}





/*
package com.nazlicanterliksiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieList: MovieModel)
    :RecyclerView.Adapter<MovieAdapter.movieCardDesign>(){

    class movieCardDesign(val movieCardBinding: MovieCardBinding)
        :RecyclerView.ViewHolder(movieCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieCardBinding = MovieCardBinding.inflate(layoutInflater,parent,false)
        return movieCardDesign(movieCardBinding)
    }

    override fun onBindViewHolder(holder: movieCardDesign, position: Int) {
        val movie = movieList.results.get(position)

        holder.movieCardBinding.apply {
            movieNameText.text = movie.original_title
            Picasso.get().load(movie.poster_path).into(movieImageView)
        }
    }

    override fun getItemCount(): Int {
        return movieList.results.count()
    }
}
*/
