package com.obvious.exercise.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.obvious.exercise.ImageData
import com.obvious.exercise.OnItemClick

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(position: Int, baseListData: ArrayList<ImageData>, onItemClick: OnItemClick)
}