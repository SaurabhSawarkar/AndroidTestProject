package com.example.myapplication.extension

import android.widget.ImageView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(picasso: Picasso, url: String) =
    picasso.load(url).fit().error(R.drawable.bean).into(this)