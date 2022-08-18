package com.obvious.exercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.obvious.exercise.repository.LocalImageRepository

class HomeViewModel :
    ViewModel() {

    fun getImageDataList(): LiveData<List<ImageData>> {
        val dataRepository = LocalImageRepository<LiveData<List<ImageData>>>(MyApp.appContext)
        return dataRepository.getData()
    }
}