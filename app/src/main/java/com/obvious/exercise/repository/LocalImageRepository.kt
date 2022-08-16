package com.obvious.exercise.repository

import androidx.lifecycle.LiveData
import com.obvious.exercise.ImageData


class LocalImageRepository<T> : DataRepository<LiveData<List<ImageData>>> {
    override fun getData(): LiveData<List<ImageData>> {
        
    }
}