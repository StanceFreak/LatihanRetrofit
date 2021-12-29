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
import com.example.latihanretrofit.model2.RomanceBooks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecycler()
//        apiResponse()

    }

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

    private fun setupRecycler() {

        adapter = MainAdapter(this)

        binding.rvRetrofit.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            MainViewModelFactory(ApiHelper(ApiBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getRomanceBooks(
            0,
            40
        ).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.rvRetrofit.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { item ->
                            retrieveList(item as ArrayList<Item>)
                        }
                    }
                    Status.ERROR -> {
                        binding.rvRetrofit.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.rvRetrofit.visibility = View.GONE
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(item: ArrayList<Item>) {
        adapter.apply {
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
//    private fun retrieveData(bookList : List<Item>) {
//        adapter.apply {
//            setData(bookList)
//            notifyDataSetChanged()
//        }
//    }
}