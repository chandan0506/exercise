package com.obvious.exercise.viewholder

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.obvious.exercise.BaseData
import com.obvious.exercise.ImageData
import com.obvious.exercise.OnItemClick
import com.obvious.exercise.R


class ImagesViewHolder(private val mContext: Context, itemView: View) : BaseViewHolder(itemView) {
    private lateinit var imageViewHome: ImageView
    private lateinit var mProgressBar: ProgressBar
    override fun bind(position: Int, baseListData: ArrayList<ImageData>, onItemClick: OnItemClick) {
        initializeViews()
        setImage(baseListData[position])
        setClickListener(onItemClick, baseListData, position)
    }

    private fun setClickListener(
        onItemClick: OnItemClick,
        baseListData: ArrayList<ImageData>,
        position: Int
    ) {
        imageViewHome.setOnClickListener {
            onItemClick.onClick(baseListData, position)
        }
    }

    private fun setImage(baseData: BaseData) {
        Glide.with(mContext)
            .load(baseData.getImageData().url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    mProgressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    mProgressBar.visibility = View.GONE
                    return false
                }

            })
            .apply(
                RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageViewHome)
    }

    private fun initializeViews() {
        imageViewHome = itemView.findViewById(R.id.imageViewHome)
        mProgressBar = itemView.findViewById(R.id.progressBarGlide)
    }
}