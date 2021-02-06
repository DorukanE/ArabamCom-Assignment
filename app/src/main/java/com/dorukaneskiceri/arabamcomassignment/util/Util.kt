package com.dorukaneskiceri.arabamcomassignment.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.GlideContext
import com.bumptech.glide.request.RequestOptions
import com.dorukaneskiceri.arabamcomassignment.R

class Util {

    val BASE_URL = "https://sandbox.arabamd.com/"
}

fun ImageView.downloadImage(url: String?, context: Context){
    val editedUrl = url?.replace("{0}", "800x600")
    val options = RequestOptions()
        .placeholder(imagePlaceHolder(context))
        .error(R.drawable.ic_launcher_foreground)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(editedUrl)
        .into(this)

}

fun imagePlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 40f
        start()
    }
}
