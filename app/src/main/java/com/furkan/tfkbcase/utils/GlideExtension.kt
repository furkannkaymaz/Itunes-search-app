package com.furkan.tfkbcase.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: Any){
    Glide.with(this)
        .load(url)
        .transform(CenterCrop(), RoundedCorners(25))
        .into(this)
}