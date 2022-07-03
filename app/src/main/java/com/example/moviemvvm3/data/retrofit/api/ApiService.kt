package com.example.moviemvvm3.data.retrofit.api

import com.example.moviemvvm3.utils.BASE_URL
import com.example.moviemvvm3.model.MovieItem
import com.example.moviemvvm3.utils.END_POINT
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    fun getAllMovies(): Call<List<MovieItem>>

    companion object {
        var api: ApiService? = null

        fun getInstance(): ApiService {
            if (api== null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create(ApiService::class.java)
            }
            return api!!
        }

    }

}