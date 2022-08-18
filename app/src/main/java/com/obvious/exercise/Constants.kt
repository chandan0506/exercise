package com.obvious.exercise

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obvious.exercise.model.ImageDataModel
import java.nio.charset.Charset

class Constants {
    companion object {
        var VIEW_TYPE_IMAGE: Int = 1
        var ITEM_CLICK_POSITION:String = "object_image_list"

        private fun getDataList(context: Context): ArrayList<ImageDataModel> {
            val gson = Gson()
            return gson.fromJson(getDataFromJson(context), object : TypeToken<List<ImageDataModel>>() {}.type)
        }

        private fun getDataFromJson(context:Context): String {
            var json = ""
            try {
                val inputStream = context.assets.open("data.json")
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charset.defaultCharset())
            } catch (e: Exception) {

            }
            return json
        }

        private fun getImageData(listImageDataModel: ArrayList<ImageDataModel>): ArrayList<ImageData> {
            val listImageData: ArrayList<ImageData> = ArrayList()
            for (imageDataModel in listImageDataModel) {
                val imageData = ImageData()
                imageData.setImageData(imageDataModel)
                listImageData.add(imageData)
            }
            return listImageData
        }

        public fun getImageList(context: Context): ArrayList<ImageData> {
            return getImageData(getDataList(context))
        }
    }
}