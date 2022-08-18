package com.obvious.exercise

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obvious.exercise.viewholder.BaseViewHolder
import com.obvious.exercise.viewholder.ViewHolderFactory

class HomeListAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var mViewHolderFactory: ViewHolderFactory = ViewHolderFactory()
    private lateinit var mImageData: List<BaseData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return mViewHolderFactory.getViewHolder(parent.context, parent, viewType)!!
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.bind(position, mImageData)
    }

    override fun getItemCount(): Int {
        return mImageData.size
    }

    override fun getItemViewType(position: Int): Int {
        return mImageData[position].getViewTypeId()
    }

    public fun setImageDataList(listBaseData: List<BaseData>) {
        this.mImageData = listBaseData
    }
}