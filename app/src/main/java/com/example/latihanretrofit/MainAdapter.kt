package com.example.latihanretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanretrofit.Model.BookItem
import com.example.latihanretrofit.Model.Item
import com.squareup.picasso.Picasso

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {

//    private var data : List<com.example.latihanretrofit.model2.Item>? = listOf()
    private var data = emptyList<com.example.latihanretrofit.model2.Item>()

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var title: TextView
//        var author: TextView
//        var ratingbar: RatingBar
//        var rate: TextView
//        var description: TextView
//        var price: TextView

        init {
            image = view.findViewById(R.id.popular_thumbnail)
            title = view.findViewById(R.id.popular_title)
//            author = view.findViewById(R.id.popular_author)
//            ratingbar = view.findViewById(R.id.popular_rating_bar)
//            rate = view.findViewById(R.id.popular_rate)
//            description = view.findViewById(R.id.popular_desc)
//            price = view.findViewById(R.id.popular_price)

            image.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_vertical_template, parent, false))

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val bookData = data[position]
        holder.title.text = bookData.volumeInfo.title
//        holder.author.text = bookData.volumeInfo.authors.toString().replace("""[\p{P}\p{S}&&[^.]]+""".toRegex(), "")
//        holder.ratingbar.rating = bookData.volumeInfo.averageRating
//        holder.rate.text = bookData.volumeInfo.averageRating.toString()
//        holder.description.text = bookData.volumeInfo.description
//        holder.price.text = String.format("Free")

        @Suppress("ConstantConditionIf")
        if(bookData.volumeInfo.imageLinks != null) {
            Picasso.get()
                    .load(bookData.volumeInfo.imageLinks.thumbnail)
                    .error(R.drawable.ic_no_thumbnail)
                    .fit()
                    .into(holder.image)
        }
        holder.itemView.setOnClickListener{
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
            i.putExtra(DetailActivity.BOOK_DETAIL, bookData.id)
            holder.itemView.context.startActivity(i)
        }


//        @Suppress("ConstantConditionIf")
//        if(bookData.saleInfo.retailPrice != null) {
//            holder.price.text = String.format("Rp %,d", bookData.saleInfo.retailPrice.amount)
//        }
//        else {
//            holder.price.text = String.format("Free")
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(bookList: List<com.example.latihanretrofit.model2.Item>) {
        data = bookList
        notifyDataSetChanged()
    }


}