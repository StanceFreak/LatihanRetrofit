package com.example.latihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanretrofit.Api.RetrofitInstance
//import com.example.latihanretrofit.Factory.MainViewModelFactory
import com.example.latihanretrofit.Model.BookItem
import com.example.latihanretrofit.Model.Books
//import com.example.latihanretrofit.Repo.Repository
//import com.example.latihanretrofit.ViewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterMain: MainAdapter
    private lateinit var manager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterMain = MainAdapter(this)
        recyclerView = findViewById(R.id.rv_retrofit)
        manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.apply {
            layoutManager = manager
            adapter = adapterMain
            setHasFixedSize(true)
        }
        JSONResponse()
    }

    private fun JSONResponse() {
        val call: Call<Books> = RetrofitInstance.api.getBooks()

        call.enqueue(object : Callback<Books> {
                    override fun onResponse(call: Call<Books>, response: Response<Books>) {

                        if (response.body() != null) {
                            Log.d("test", response.body()!!.toString())
                            adapterMain.setData(response.body()!!.items)
//                            setupRecycler()
                        }

                    }

                    override fun onFailure(call: Call<Books>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
    }

    private fun setupRecycler() {
        adapterMain = MainAdapter(this)
        recyclerView = findViewById(R.id.rv_retrofit)
        manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.apply {
            layoutManager = manager
            adapter = adapterMain
            setHasFixedSize(true)
        }
//        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false)
//        recycler.adapter(mainAdapter)
    }
}