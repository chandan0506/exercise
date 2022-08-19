package com.obvious.exercise.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obvious.exercise.ImageData
import com.obvious.exercise.OnItemClick
import com.obvious.exercise.viewholder.BaseViewHolder
import com.obvious.exercise.viewholder.ViewHolderFactory

class HomeListAdapter(val onItemClick: OnItemClick) : RecyclerView.Adapter<BaseViewHolder>() {
    private var mViewHolderFactory: ViewHolderFactory = ViewHolderFactory()
    private lateinit var mImageData: ArrayList<ImageData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return mViewHolderFactory.getViewHolder(parent.context, parent, viewType)!!
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.bind(position, mImageData, onItemClick)
    }

    override fun getItemCount(): Int {
        return mImageData.size
    }

    override fun getItemViewType(position: Int): Int {
        return mImageData[position].getViewTypeId()
    }

    fun setImageDataList(listBaseData: ArrayList<ImageData>) {
        this.mImageData = listBaseData
    }
}