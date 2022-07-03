package com.example.moviemvvm3.screen.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviemvvm3.R
import com.example.moviemvvm3.data.retrofit.RetrofitRepository
import com.example.moviemvvm3.data.retrofit.api.ApiService
import com.example.moviemvvm3.data.retrofit.api.ApiService.Companion.api
import com.example.moviemvvm3.databinding.FragmentMainBinding
import com.example.moviemvvm3.utils.MyViewModelFactory

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: MainViewModel
    private val api = ApiService.getInstance()
    val adapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,
        MyViewModelFactory(RetrofitRepository(api))).get(MainViewModel::class.java)
        binding.mainRv.adapter = adapter

        viewModel.movieList.observe(this, {
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()

    }

}