package com.geraa1985.mixdrinks.ui.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.geraa1985.mixdrinks.mvp.model.repositoties.ILoadImage

class GlideImgLoader: ILoadImage<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide
            .with(container.context)
            .load(url)
            .into(container)
    }
}