package com.obvious.exercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.obvious.homeactivity.R

class ViewHolderFactory : VHFactory {
    override fun getFieldViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: ViewType
    ): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View
        when (viewType) {
            ViewType.VIEW_TYPE_IMAGE -> {
                view = inflater.inflate(R.layout.list_item, parent, false)
                return ImagesViewHolder(context, view)
            }
        }
    }
}