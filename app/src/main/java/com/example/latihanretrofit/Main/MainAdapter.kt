package com.example.latihanretrofit.Main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanretrofit.Detail.DetailActivity
import com.example.latihanretrofit.R
import com.example.latihanretrofit.model2.Item
import com.squareup.picasso.Picasso

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {

    private var data = ArrayList<Item>()

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var title: TextView

        init {
            image = view.findViewById(R.id.popular_thumbnail)
            title = view.findViewById(R.id.popular_title)
            image.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_vertical_template, parent, false))

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val bookData = data[position]
        holder.title.text = bookData.volumeInfo.title

        @Suppress("ConstantConditionIf")
        if(bookData.volumeInfo.imageLinks != null) {
            Picasso.get()
                    .load(bookData.volumeInfo.imageLinks.thumbnail)
                    .placeholder(R.drawable.ic_book_icon)
                    .error(R.drawable.ic_book_icon)
                    .fit()
                    .into(holder.image)
        }
        holder.itemView.setOnClickListener{
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
            i.putExtra(DetailActivity.BOOK_DETAIL, bookData)
            holder.itemView.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: ArrayList<Item>) {
        this.data.apply {
            clear()
            addAll(data)
        }
    }


}