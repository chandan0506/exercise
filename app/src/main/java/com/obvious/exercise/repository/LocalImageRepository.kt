package com.obvious.exercise.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obvious.exercise.ImageData
import com.obvious.exercise.model.ImageDataModel
import java.nio.charset.Charset


class LocalImageRepository<T>(private val context: Context) :
    DataRepository<LiveData<List<ImageData>>> {
    override fun getData(): LiveData<List<ImageData>> {
        Log.d("TESTINGG","getData repo")

        val mutableLiveData = MutableLiveData<List<ImageData>>()
        mutableLiveData.value = getImageData(getDataList())
        return mutableLiveData
    }

    private fun getDataList(): List<ImageDataModel> {
        val gson = Gson()
        return gson.fromJson(getDataFromJson(), object : TypeToken<List<ImageDataModel>>() {}.type)
    }

    private fun getDataFromJson(): String {
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

    private fun getImageData(listImageDataModel: List<ImageDataModel>): List<ImageData> {
        val listImageData: ArrayList<ImageData> = ArrayList()
        for (imageDataModel in listImageDataModel) {
            val imageData = ImageData()
            imageData.setImageData(imageDataModel)
            listImageData.add(imageData)
        }
        return listImageData
    }
}