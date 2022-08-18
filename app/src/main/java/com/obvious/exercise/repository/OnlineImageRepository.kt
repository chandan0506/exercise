package com.obvious.exercise.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.obvious.exercise.ImageData

class OnlineImageRepository : DataRepository<LiveData<List<ImageData>>> {
    override fun getData(): LiveData<List<ImageData>> {
        //Code for fetching image from online
        //Currently sending blank object
        val imageData = ImageData()
        val list = ArrayList<ImageData>()
        list.add(imageData)
        val mutableLiveData = MutableLiveData<List<ImageData>>()
        mutableLiveData.value = list
        return mutableLiveData
    }
}