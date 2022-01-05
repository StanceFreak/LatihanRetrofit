package com.example.latihanretrofit.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RatingBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.latihanretrofit.Api.ApiBuilder
import com.example.latihanretrofit.Api.ApiHelper
import com.example.latihanretrofit.Factory.MainViewModelFactory
import com.example.latihanretrofit.Utils.Status
import com.example.latihanretrofit.databinding.ActivityMainBinding
import com.example.latihanretrofit.model2.Item
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

class MainActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        mainAdapter = MainAdapter(this, arrayListOf())
        binding.rvRetrofit.layoutManager = GridLayoutManager(this, 2)
        binding.rvRetrofit.setHasFixedSize(true)
        mainAdapter.notifyDataSetChanged()
        binding.rvRetrofit.adapter = mainAdapter

//        setupRecycler()
        setupObservers()
//        apiResponse()
        setContentView(binding.root)
    }

//    private fun setupRecycler() {
//        mainAdapter = MainAdapter(this, arrayListOf())
//
//        binding.rvRetrofit.apply {
//            adapter = mainAdapter
//            layoutManager = GridLayoutManager(applicationContext, 2)
//            setHasFixedSize(true)
//        }
//    }

    override fun onRatingChanged(RatingBar: RatingBar?, p1: Float, p2: Boolean) {
        TODO("Not yet implemented")
    }

//    private fun apiResponse() {
//        val call: Call<RomanceBooks> = ApiBuilder.apiService.getRomanceBooks(
//            0,
//            40
//        )
//
//        call.enqueue(object : Callback<RomanceBooks> {
//                    override fun onResponse(call: Call<RomanceBooks>, response: Response<RomanceBooks>) {
//
//                        if (response.isSuccessful) {
//                            Log.d("test", response.body()!!.toString())
//                            adapter.setData(response.body()!!.items)
//                        }
//
//                    }
//
//                    override fun onFailure(call: Call<RomanceBooks>, t: Throwable) {
//                        Toast.makeText(this@MainActivity, "Check your network connection", Toast.LENGTH_LONG).show()
//                        Log.e("error", "OnFailure : " + t.message)
//                    }
//
//                })
//    }

//    private fun setupViewModel() {
//        viewModel = ViewModelProviders.of(
//            this,
//            MainViewModelFactory(ApiHelper(ApiBuilder.apiService))
//        ).get(MainViewModel::class.java)
//    }

//    @Suppress("CAST_NEVER_SUCCEEDS")
    private fun setupObservers() {

        viewModel = ViewModelProviders.of(
                this,
                MainViewModelFactory(ApiHelper(ApiBuilder.apiService))
        ).get(MainViewModel::class.java)

        viewModel.getRomanceBooks(
            0,
            40
        ).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.rvRetrofit.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { response ->
                            mainAdapter.setData(response.items)
                        }
                    }
                    Status.ERROR -> {
//                        binding.rvRetrofit.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        Log.e("error", it.message.toString())
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
//                        binding.rvRetrofit.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(item: List<Item>) {
        mainAdapter.apply {
            setData(item)
            notifyDataSetChanged()
        }
    }

//    private fun setupObservers() {
//        viewModel.getRomanceBooks(
//            0,
//            40
//        ).observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        resource.data?.let { item ->
//                            retrieveData(item) as List<Item>
////                            adapter = MainAdapter(this)
////                            adapter.setData(item)
////                            adapter.notifyDataSetChanged()
//                        }
//                    }
//                    Status.ERROR -> {
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                    }
//                    Status.LOADING
//                }
//            }
//        })
//    }
//
    private fun retrieveData(bookList : List<Item>) {
        mainAdapter.apply {
            setData(bookList)
            notifyDataSetChanged()
        }
    }
}