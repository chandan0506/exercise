package com.obvious.exercise.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.obvious.exercise.R

class ViewHolderFactory : VHFactory {
    override fun getViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder? {
        val inflater = LayoutInflater.from(parent.context)
        val view: View
        when (viewType) {
            1 -> {
                view = inflater.inflate(R.layout.list_item, parent, false)
                return ImagesViewHolder(context, view)
            }
        }
        return null
    }
}