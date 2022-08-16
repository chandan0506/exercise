package com.obvious.exercise.repository

interface DataRepository<T> {
    fun getData(): T
}