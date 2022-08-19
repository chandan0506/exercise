package com.obvious.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.obvious.exercise.adapter.DetailsViewPagerAdapter

class DetailsActivity : AppCompatActivity() {
    private lateinit var mViewPagerDetail: ViewPager
    private lateinit var mImageList: ArrayList<ImageData>
    private var mItemClickedPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        title = "Details"
        initializeViews()
        mItemClickedPosition = intent.getIntExtra(Constants.ITEM_CLICK_POSITION, 0)
        mImageList = Constants.getImageList(this)
        Constants.sortImageList(mImageList)
        val mAdapter = DetailsViewPagerAdapter(this, mImageList)
        mViewPagerDetail.adapter = mAdapter
        mViewPagerDetail.currentItem = mItemClickedPosition
    }

    private fun initializeViews() {
        mViewPagerDetail = findViewById(R.id.view_pager_detail)
    }
}