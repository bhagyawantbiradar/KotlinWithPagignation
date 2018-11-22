package com.example.bhagyantbiradar.kotlincodechallenge.activities.MovieDetails

import com.example.bhagyantbiradar.kotlincodechallenge.BaseContract

class MovieDetailsContract {

    interface View : BaseContract.View {

        fun initView()

    }

    interface Presenter : BaseContract.Presenter<MovieDetailsContract.View> {

    }

    interface Model {

    }
}