package com.globant.marvelcharacters.ui.details.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.globant.marvelcharacters.R
import com.globant.marvelcharacters.helper.Constants
import com.globant.marvelcharacters.helper.GetKeys

@BindingAdapter("marvelCharacterImage")
fun marvelCharacterImage(view: ImageView, thumbnail: String?) {
    thumbnail?.let {
        val glideUrl = GlideUrl(
            thumbnail,
            LazyHeaders.Builder()
                .addHeader(Constants.timestamp, GetKeys.getTimestamp())
                .addHeader(Constants.apikey, GetKeys.getApiKey())
                .addHeader(Constants.hash, GetKeys.getMD5Hash())
                .build()
        )
        val options = RequestOptions.placeholderOf(R.drawable.android_icon).error(R.drawable.error)
        Glide.with(view).setDefaultRequestOptions(options).load(glideUrl ?: "")
            .skipMemoryCache(true)
            .into(view)
    }
}



