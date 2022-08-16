package com.obvious.exercise

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(position:Int, baseListData: BaseData)
}