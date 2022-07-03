package com.example.moviemvvm3.screen.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviemvvm3.databinding.ItemMovieCardBinding
import com.example.moviemvvm3.model.Movie
import com.example.moviemvvm3.model.MovieItem

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var movies = mutableListOf<MovieItem>()
    fun setMovieList(movies: List<MovieItem>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieCardBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.itemTitle.text = movie.name
        holder.binding.itemDate.text = movie.category
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.itemImg)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MainViewHolder(val binding: ItemMovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
    }

}