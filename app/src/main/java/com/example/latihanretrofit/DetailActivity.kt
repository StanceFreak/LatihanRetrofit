package com.example.latihanretrofit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanretrofit.model2.Item
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    companion object {
        const val BOOK_DETAIL = "book_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bookExtras = intent.getParcelableExtra<Item>(BOOK_DETAIL)

        val thumbnail = findViewById<ImageView>(R.id.detail_thumbnail)
        val title = findViewById<TextView>(R.id.detail_title)
        val author = findViewById<TextView>(R.id.detail_author)
        val rating = findViewById<RatingBar>(R.id.detail_average_rating)
        val ratingCount = findViewById<TextView>(R.id.detail_rating_count)
        val description = findViewById<TextView>(R.id.detail_desc)
        val webview = findViewById<LinearLayout>(R.id.detail_webview)

        if (bookExtras != null) {
            title.text = bookExtras.volumeInfo.title
            author.text = bookExtras.volumeInfo.authors.toString()
            rating.rating = bookExtras.volumeInfo.averageRating
            ratingCount.text = bookExtras.volumeInfo.averageRating.toString()
            description.text = bookExtras.volumeInfo.description
            Picasso.get()
                .load(bookExtras.volumeInfo.imageLinks.thumbnail)
                .error(R.drawable.ic_no_thumbnail)
                .fit()
                .into(thumbnail)
            webview.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(bookExtras.volumeInfo.previewLink))
                startActivity(i)
            }
        }
        holder.author.text = data.volumeInfo.authors.toString().replace("""[\p{P}\p{S}&&[^.]]+""".toRegex(), "")
        holder.ratingbar.rating = data.volumeInfo.averageRating
        holder.rate.text = data.volumeInfo.averageRating.toString()
        holder.description.text = data.volumeInfo.description
        holder.price.text = String.format("Free")
    }
}