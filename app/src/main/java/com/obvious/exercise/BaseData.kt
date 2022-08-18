package com.obvious.exercise

import com.obvious.exercise.model.ImageDataModel

abstract class BaseData {
    abstract fun getViewTypeId(): Int
    abstract fun getImageData(): ImageDataModel
    abstract fun setImageData(imageDataModel: ImageDataModel)
}