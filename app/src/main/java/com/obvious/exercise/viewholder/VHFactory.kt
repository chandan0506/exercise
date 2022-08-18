package com.obvious.exercise.viewholder

import android.content.Context
import android.view.ViewGroup

interface VHFactory {
    fun getViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder?
}