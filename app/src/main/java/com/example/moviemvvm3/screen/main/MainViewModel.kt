package com.example.moviemvvm3.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm3.data.retrofit.RetrofitRepository
import com.example.moviemvvm3.model.Movie
import com.example.moviemvvm3.model.MovieItem
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(private val repository: RetrofitRepository): ViewModel() {
    val movieList = MutableLiveData<List<MovieItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : retrofit2.Callback<List<MovieItem>> {
            override fun onResponse(call: Call<List<MovieItem>>, response: Response<List<MovieItem>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MovieItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}
