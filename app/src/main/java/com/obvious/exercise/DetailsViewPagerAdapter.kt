package com.obvious.exercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


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
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View =
            mLayoutInflater.inflate(R.layout.details_view_pager_item, container, false)
        val imageView = itemView.findViewById<View>(R.id.iv_details) as ImageView
        loadImage(imageView, position)
        container.addView(itemView)
        return itemView
    }

    private fun loadImage(imageView: ImageView, position: Int) {
        Glide.with(mContext)
            .load(mImageList[position].getImageData().url)
            .apply(
                RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageView)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}