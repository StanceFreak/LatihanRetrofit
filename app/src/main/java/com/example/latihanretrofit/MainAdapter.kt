package com.example.latihanretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanretrofit.Model.BookItem
import com.example.latihanretrofit.Model.Item

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {

    private var data : List<Item> = listOf()

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var title: TextView
        var author: TextView
        var rating: RatingBar
        var price: TextView

        init {
            image = view.findViewById(R.id.popular_thumbnail)
            title = view.findViewById(R.id.popular_title)
            author = view.findViewById(R.id.popular_author)
            rating = view.findViewById(R.id.popular_rating)
            price = view.findViewById(R.id.popular_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_template, parent, false))

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val bookData = data[position]
        Glide.with(context)
            .load(bookData.volumeInfo.imageLinks.thumbnail)
            .into(holder.image)
        holder.title.text = bookData.volumeInfo.title
        holder.author.text = bookData.volumeInfo.authors.toString()
        holder.rating.rating = bookData.volumeInfo.averageRating.toFloat()
        holder.price.text = bookData.saleInfo.retailPrice.amount.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(bookList: List<Item>) {
        data = bookList
        notifyDataSetChanged()
    }

}