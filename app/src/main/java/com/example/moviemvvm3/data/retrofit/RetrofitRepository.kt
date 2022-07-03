package com.example.moviemvvm3.data.retrofit

import com.example.moviemvvm3.data.retrofit.api.ApiService

class RetrofitRepository (val api: ApiService){
    fun getAllMovies() = api.getAllMovies()
}