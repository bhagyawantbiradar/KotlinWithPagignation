package com.example.bhagyantbiradar.kotlincodechallenge.activities.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.bhagyantbiradar.kotlincodechallenge.R
import com.example.bhagyantbiradar.kotlincodechallenge.adapters.MoviesListAdapter
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View, View.OnClickListener {
    override fun showNoMoreResultsFound() {
        Toast.makeText(this, "No more results found.", Toast.LENGTH_LONG).show()
    }

    override fun showTooSmallNameError() {
        Toast.makeText(this, "Movie name should contain minimum 4 characters", Toast.LENGTH_LONG).show()
    }

    lateinit var moviesListAdapter: MoviesListAdapter
    lateinit var presenter: MainContract.Presenter
    var count: Int = 1
    val API_KEY = "28991504"

    override fun growList(newSearches: ArrayList<Search>) {
        moviesListAdapter.growList(newSearches)
    }

    override fun initViews() {
        rvList.layoutManager = LinearLayoutManager(this)
        btnSearch.setOnClickListener(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.subscribe()
        initViews()
    }

    fun onSearchClicked() {
        presenter.onSearchClicked(API_KEY, etQuery.text.toString(), count, false)
        rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    presenter.onSearchClicked(API_KEY, etQuery.text.toString(), count++, true)
                }
            }
        })
    }


    override fun showList(list: ArrayList<Search>) {
        moviesListAdapter = MoviesListAdapter(this, list, presenter as MainPresenter)
        rvList.adapter = moviesListAdapter

    }

    override fun onClick(v: View?) {
        onSearchClicked()
    }
}
