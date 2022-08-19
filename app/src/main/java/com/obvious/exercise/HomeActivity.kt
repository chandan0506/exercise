package com.obvious.exercise

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.obvious.exercise.adapter.HomeListAdapter


class HomeActivity : AppCompatActivity(), OnItemClick {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mProgressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Home"
        initializeViews()
        initializeObserver()
        handleProgressBar(true)
        handleRecyclerView(false)
    }

    private fun handleRecyclerView(isVisible: Boolean) {
        if (isVisible) {
            mRecyclerView.visibility = View.VISIBLE
        } else {
            mRecyclerView.visibility = View.GONE
        }
    }

    private fun handleProgressBar(isVisible: Boolean) {
        if (isVisible) {
            mProgressBar.visibility = View.VISIBLE
        } else {
            mProgressBar.visibility = View.GONE
        }
    }

    private fun initializeObserver() {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val imageListObserver: Observer<ArrayList<ImageData>> = Observer<ArrayList<ImageData>> {
            handleProgressBar(false)
            handleRecyclerView(true)
            sortList(it)
            initializeRecyclerView(it)
        }
        mHomeViewModel.getImageDataList().observe(this, imageListObserver)
    }

    private fun sortList(list: ArrayList<ImageData>?) {
        Constants.sortImageList(list)
    }

    private fun initializeViews() {
        mRecyclerView = findViewById(R.id.rv_home)
        mProgressBar = findViewById(R.id.progressBar)
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
