package com.obvious.exercise

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment

interface VHFactory {
    fun getFieldViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: ViewType
    ): BaseViewHolder?
}