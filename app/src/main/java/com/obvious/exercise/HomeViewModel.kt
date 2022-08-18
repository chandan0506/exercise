package com.obvious.exercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.obvious.exercise.repository.LocalImageRepository

class HomeViewModel :
    ViewModel() {

    fun getImageDataList(): LiveData<ArrayList<ImageData>> {
        val dataRepository = LocalImageRepository<LiveData<ArrayList<ImageData>>>(MyApp.appContext)
        return dataRepository.getData()
    }
}