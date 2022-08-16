package com.obvious.exercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.obvious.exercise.repository.LocalImageRepository

class HomeViewModel : ViewModel() {
    private val imageDataList = MutableLiveData<List<ImageData>>()

    fun getImageDataList(): LiveData<List<ImageData>> {
        val dataRepository = LocalImageRepository<LiveData<List<ImageData>>>()
        return dataRepository.getData()
    }
}