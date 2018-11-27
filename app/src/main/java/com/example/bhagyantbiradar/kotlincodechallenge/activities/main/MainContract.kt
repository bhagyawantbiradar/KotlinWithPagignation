package com.example.bhagyantbiradar.kotlincodechallenge.activities.main

import com.example.bhagyantbiradar.kotlincodechallenge.BaseContract
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search

interface MainContract {
    interface View : BaseContract.View {
        /**
         * @author Bhagyawant Biradar
         * To initialize the views
         */
        fun initViews()

        /**
         * @author Bhagyawant Biradar
         * @param list : array list of the movies
         * to show the list by setting adapter to recycler view
         */
        fun showList(list: ArrayList<Search>)

        /**
         * @author Bhagyawant Biradar
         * @param newSearches Used for pagignation to load new movies from API on next pages when recycler view scroll ends
         */
        fun growList(newSearches: ArrayList<Search>)

        /**
         ** @author Bhagyawant Biradar
         * Show error if user enters less than 4 characters in movie name
         */
        fun showTooSmallNameError()

        /**
         * Show error if there are no more results from API
         * @author Bhagyawant Biradar
         */
        fun showNoMoreResultsFound()
    }

    interface Presenter : BaseContract.Presenter<MainContract.View> {
        /**
         * @author Bhagyawant Biradar
         * Show when user press search button
         * @param apiKey Given api key
         * @param query movie name to search
         * @param page page number to show result from total results
         * @param isScrollEnd is recyclerview scroll is not scrolling more
         */
        fun onSearchClicked(apiKey: String, query: String, page: Int, isScrollEnd: Boolean)
    }

    interface Model {
        /**
         * TODO Need to implemment
         */
        fun addDataToDatabase()
    }
}