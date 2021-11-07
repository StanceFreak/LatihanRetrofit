package com.example.latihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanretrofit.Api.RetrofitInstance
//import com.example.latihanretrofit.Factory.MainViewModelFactory
import com.example.latihanretrofit.Model.BookItem
import com.example.latihanretrofit.Model.Books
import com.example.latihanretrofit.model2.RomanceBooks
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
//import com.example.latihanretrofit.Repo.Repository
//import com.example.latihanretrofit.ViewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterMain: MainAdapter
    private lateinit var manager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val image = findViewById<ImageView>(R.id.popular_thumbnail)
//        image.clipToOutline = true

        adapterMain = MainAdapter(this)
        recyclerView = findViewById(R.id.rv_retrofit)

        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = adapterMain
            setHasFixedSize(true)
        }
        JSONResponse()

    }

    override fun onRatingChanged(RatingBar: RatingBar?, p1: Float, p2: Boolean) {
        TODO("Not yet implemented")
    }

    private fun JSONResponse() {
        val call: Call<RomanceBooks> = RetrofitInstance.api.getRomanceBooks()

        call.enqueue(object : Callback<RomanceBooks> {
                    override fun onResponse(call: Call<RomanceBooks>, response: Response<RomanceBooks>) {

                        if (response.isSuccessful) {
                            Log.d("test", response.body()!!.toString())
                            adapterMain.setData(response.body()!!.items)
                        }

                    }

                    override fun onFailure(call: Call<RomanceBooks>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Check your network connection", Toast.LENGTH_LONG).show()
                        Log.e("error", "OnFailure : " + t.message)
                    }

                })
    }

    private fun setupRecycler() {
        val adapterMain = MainAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_retrofit)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterMain
            setHasFixedSize(true)
        }
    }
}