package com.example.bhagyantbiradar.kotlincodechallenge.activities.MovieDetails

class MovieDetailsPresenter : MovieDetailsContract.Presenter {
    lateinit var view: MovieDetailsContract.View

    constructor(view: MovieDetailsContract.View) {
        this.view = view
    }


    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: MovieDetailsContract.View) {
    }

}