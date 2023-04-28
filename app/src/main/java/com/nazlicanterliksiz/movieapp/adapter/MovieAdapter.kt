package com.nazlicanterliksiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList : ArrayList<MovieModel>, private val listener : Listener)
    : RecyclerView.Adapter<MovieAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(movieModel: MovieModel)
    }

    class RowHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClick(movieList.get(position))
        }

        holder.binding.movieNameText.text = movieList.get(position).original_title

    }


}

/*package com.nazlicanterliksiz.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.databinding.MovieCardBinding
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieList: ArrayList<MovieModel>)
    :RecyclerView.Adapter<MovieAdapter.movieCardDesign>(){

    class movieCardDesign(val movieCardBinding: MovieCardBinding)
        :RecyclerView.ViewHolder(movieCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieCardBinding = MovieCardBinding.inflate(layoutInflater,parent,false)
        return movieCardDesign(movieCardBinding)
    }

    override fun onBindViewHolder(holder: movieCardDesign, position: Int) {
        val movie = movieList[position]

        holder.movieCardBinding.apply {
            movieNameText.text = movie.original_title
            Picasso.get().load(movie.poster_path).into(movieImageView)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
*/
/*
package com.atilsamancioglu.retrofitkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.movieapp.R
import com.nazlicanterliksiz.movieapp.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList : ArrayList<MovieModel>, private val listener : Listener)
    : RecyclerView.Adapter<MovieAdapter.RowHolder>() {


    class RowHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val movie = movieList[position]

        holder.itemView.apply {
            movieNameText.text = movie.original_title
            Picasso.get().load(movie.poster_path).into(movieImageView)
        }

    }
}
*/

