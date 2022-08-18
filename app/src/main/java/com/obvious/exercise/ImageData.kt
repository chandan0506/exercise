package com.obvious.exercise

import com.obvious.exercise.model.ImageDataModel

class ImageData : BaseData() {
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