package com.obvious.exercise.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.obvious.exercise.Constants
import com.obvious.exercise.ImageData


class LocalImageRepository<T>(private val context: Context) :
    DataRepository<LiveData<ArrayList<ImageData>>> {
    override fun getData(): LiveData<ArrayList<ImageData>> {
        Log.d("TESTINGG", "getData repo")

        val mutableLiveData = MutableLiveData<ArrayList<ImageData>>()
        mutableLiveData.value = Constants.getImageList(context)
        return mutableLiveData
    }


}