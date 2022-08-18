package com.obvious.exercise.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.obvious.exercise.BaseData
import com.obvious.exercise.ImageData
import com.obvious.exercise.OnItemClick


class ImagesViewHolder(private val mContext: Context, itemView: View) : BaseViewHolder(itemView) {
    private lateinit var imageViewHome: ImageView
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
            .apply(
                RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageViewHome)
    }

    private fun initializeViews() {
        imageViewHome = itemView.findViewById(com.obvious.exercise.R.id.imageViewHome)
    }
}