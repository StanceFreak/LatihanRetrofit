package com.example.latihanretrofit.Detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanretrofit.R
import com.example.latihanretrofit.databinding.ActivityDetailBinding
import com.example.latihanretrofit.model2.Item
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val BOOK_DETAIL = "book_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookExtras = intent.getParcelableExtra<Item>(BOOK_DETAIL)

        if (bookExtras != null) {
            binding.detailTitle.text = bookExtras.volumeInfo.title
            binding.detailAuthor.text = bookExtras.volumeInfo.authors.toString()
            binding.detailAverageRating.rating = bookExtras.volumeInfo.averageRating
            binding.detailRatingCount.text = bookExtras.volumeInfo.averageRating.toString()
            binding.detailDesc.text = bookExtras.volumeInfo.description
            Picasso.get()
                .load(bookExtras.volumeInfo.imageLinks.thumbnail)
                .error(R.drawable.ic_no_thumbnail)
                .fit()
                .into(binding.detailThumbnail)
            binding.detailWebview.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(bookExtras.volumeInfo.previewLink))
                startActivity(i)
            }
        }
    }
}