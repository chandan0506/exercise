package com.obvious.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mHomeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()

        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val imageListObserver: Observer<List<ImageData>> = Observer<List<ImageData>> {
            initializeRecyclerView(it)
        }
        mHomeViewModel.getImageDataList().observe(this, imageListObserver)
    }

    private fun initializeViews() {
        mRecyclerView = findViewById(R.id.rv_home)
    }

    private fun initializeRecyclerView(list: List<ImageData>) {
        val homeListAdapter = HomeListAdapter()
        homeListAdapter.setImageDataList(list)
        mRecyclerView.adapter = homeListAdapter
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}