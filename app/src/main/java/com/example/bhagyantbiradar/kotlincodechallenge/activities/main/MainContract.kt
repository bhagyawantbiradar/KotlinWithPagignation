package com.example.bhagyantbiradar.kotlincodechallenge.activities.main

import com.example.bhagyantbiradar.kotlincodechallenge.BaseContract
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search

class MainContract {
    interface View : BaseContract.View {
        fun showList(list: ArrayList<Search>)
        fun initViews()
        fun growList(newSearches : ArrayList<Search>)
        fun showTooSmallNameError()
        fun showNoMoreResultsFound()
    }

    interface Presenter : BaseContract.Presenter<MainContract.View> {
        fun onSearchClicked(apiKey: String, query: String, page: Int, isScrollEnd: Boolean)
    }

    interface Model {
        fun addDataToDatabase()
    }
}