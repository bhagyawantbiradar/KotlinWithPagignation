package com.example.bhagyantbiradar.kotlincodechallenge.activities.main

import com.example.bhagyantbiradar.kotlincodechallenge.interfaces.APIInterface
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.SearchResult
import com.example.bhagyantbiradar.kotlincodechallenge.utils.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainPresenter(var view: MainContract.View) : MainContract.Presenter {


    override fun onSearchClicked(apiKey: String, query: String, page: Int, isScrollEnd: Boolean) {
        if (query.length < 4) {
            view.showTooSmallNameError()
        } else {
            val sApiService = ApiClient.client!!.create(APIInterface::class.java)

            val searchMovieService = sApiService.search(apiKey, "$query", "$page")

            searchMovieService.enqueue(object : retrofit2.Callback<SearchResult> {
                override fun onFailure(call: Call<SearchResult>, t: Throwable) {

                }

                override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                    val searchResult = response.body()
                    if (searchResult != null) {
                        if (searchResult.response == "True") {
                            if (!isScrollEnd)
                                view.showList(searchResult.search)
                            else view.growList(searchResult.search)
                        } else {
                            view.showNoMoreResultsFound()
                        }
                    }
                }

            })

        }


    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: MainContract.View) {
    }


}