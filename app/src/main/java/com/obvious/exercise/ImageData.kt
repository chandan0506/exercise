package com.obvious.exercise

import android.os.Parcelable
import com.obvious.exercise.model.ImageDataModel
import kotlinx.parcelize.IgnoredOnParcel

import kotlinx.parcelize.Parcelize

@Parcelize
class ImageData : BaseData(), Parcelable {
    @IgnoredOnParcel
    private lateinit var imageDataModel: ImageDataModel
    override fun getViewTypeId(): Int {
        return Constants.VIEW_TYPE_IMAGE
    }

    override fun getImageData(): ImageDataModel {
        return imageDataModel
    }

    override fun setImageData(imageDataModel: ImageDataModel) {
        this.imageDataModel = imageDataModel
    }
}