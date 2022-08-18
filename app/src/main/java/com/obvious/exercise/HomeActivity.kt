package com.obvious.exercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity(), OnItemClick {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mHomeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeObserver()
    }

    private fun initializeObserver() {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val imageListObserver: Observer<ArrayList<ImageData>> = Observer<ArrayList<ImageData>> {
            initializeRecyclerView(it)
        }
        mHomeViewModel.getImageDataList().observe(this, imageListObserver)
    }

    private fun initializeViews() {
        mRecyclerView = findViewById(R.id.rv_home)
    }

    private fun initializeRecyclerView(list: ArrayList<ImageData>) {
        val homeListAdapter = HomeListAdapter(this)
        homeListAdapter.setImageDataList(list)
        mRecyclerView.adapter = homeListAdapter
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onClick(imageList: ArrayList<ImageData>, position: Int) {
        val detailsIntent = Intent(this, DetailsActivity::class.java)
        detailsIntent.putExtra(Constants.ITEM_CLICK_POSITION, position)
        startActivity(detailsIntent)
    }
}
