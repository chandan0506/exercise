package com.obvious.exercise

class ImageData : BaseData() {
    override fun getViewTypeId(): ViewType {
        return ViewType.VIEW_TYPE_IMAGE
    }
    override fun getImageUrl(): String {
        return ""
    }
}