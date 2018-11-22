package com.example.bhagyantbiradar.kotlincodechallenge.activities.main

import com.example.bhagyantbiradar.kotlincodechallenge.APIInterface
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.SearchResult
import com.example.bhagyantbiradar.kotlincodechallenge.utils.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainPresenter : MainContract.Presenter {

    lateinit var view: MainContract.View

    constructor(view: MainContract.View) {
        this.view = view
    }


    override fun onSearchClicked(apiKey: String, query: String, page: Int, isScrollEnd: Boolean) {
        if (query.length < 4) {
            view.showTooSmallNameError()
        } else {
            val sApiService = ApiClient.client!!.create(APIInterface::class.java)

            val deliveryService = sApiService.search(apiKey, "$query", "$page")

            deliveryService.enqueue(object : retrofit2.Callback<SearchResult> {
                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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