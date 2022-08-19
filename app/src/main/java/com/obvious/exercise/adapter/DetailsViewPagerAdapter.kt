package com.obvious.exercise.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.obvious.exercise.ImageData
import com.obvious.exercise.R


class DetailsViewPagerAdapter(
    private val mContext: Context,
    private val mImageList: ArrayList<ImageData>
) :
    PagerAdapter() {
    private val mLayoutInflater =
        mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return mImageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View =
            mLayoutInflater.inflate(R.layout.details_view_pager_item, container, false)
        val imageView = itemView.findViewById(R.id.iv_details) as ImageView
        val title = itemView.findViewById(R.id.tv_title) as TextView
        val description = itemView.findViewById(R.id.tv_description) as TextView
        val copyright = itemView.findViewById(R.id.tv_copyright) as TextView
        val progressBar = itemView.findViewById(R.id.progressBarDetail) as ProgressBar
        title.text = mImageList[position].getImageData().title
        description.text = mImageList[position].getImageData().explanation
        val copyrightText = mImageList[position].getImageData().copyright
        if (!TextUtils.isEmpty(copyrightText)) {
            copyright.text = mContext.getString(
                R.string.copyright_text,
                mImageList[position].getImageData().copyright
            )
        }
        loadImage(imageView, position, progressBar)
        container.addView(itemView)
        return itemView
    }

    private fun loadImage(imageView: ImageView, position: Int, progressBar: ProgressBar) {
        Glide.with(mContext)
            .load(mImageList[position].getImageData().url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

            })
            .apply(
                RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageView)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}