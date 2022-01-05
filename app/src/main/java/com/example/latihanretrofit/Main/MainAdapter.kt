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
import com.example.latihanretrofit.databinding.RecyclerVerticalTemplateBinding
import com.example.latihanretrofit.model2.Item
import com.example.latihanretrofit.model2.RomanceBooks
import com.squareup.picasso.Picasso

class MainAdapter(
        val context: Context,
        private var dataList : ArrayList<Item>
        ): RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {

//    private var dataList : MutableList<Item> = mutableListOf()

    inner class HomeViewHolder(val binding: RecyclerVerticalTemplateBinding) : RecyclerView.ViewHolder(binding.root) {

//        private var image: ImageView = itemView.findViewById(R.id.popular_thumbnail)
//        private var title: TextView = itemView.findViewById(R.id.popular_title)

        fun bind(item: Item) {
            if(item.volumeInfo?.imageLinks != null) {
                Picasso.get()
                    .load(item.volumeInfo.imageLinks.thumbnail)
                    .error(R.drawable.ic_no_thumbnail)
                    .fit()
                    .into(binding.popularThumbnail)
            }

            binding.popularTitle.text = item.volumeInfo.title
            binding.popularThumbnail.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
                val itemBinding = RecyclerVerticalTemplateBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false)
                return HomeViewHolder(itemBinding)
//            LayoutInflater
//                .from(parent.context)
//                .inflate(R.layout.recycler_vertical_template, parent, false)

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val bookData = dataList[position]
        holder.bind(bookData)
//        holder.title.text = bookData.volumeInfo.title
//
//        @Suppress("ConstantConditionIf")
//        if(bookData.volumeInfo.imageLinks != null) {
//            Picasso.get()
//                    .load(bookData.volumeInfo.imageLinks.thumbnail)
//                    .placeholder(R.drawable.ic_book_icon)
//                    .error(R.drawable.ic_book_icon)
//                    .fit()
//                    .into(holder.image)
//        }
        holder.itemView.setOnClickListener{
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
            i.putExtra(DetailActivity.BOOK_DETAIL, bookData)
            holder.itemView.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<Item>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }


}