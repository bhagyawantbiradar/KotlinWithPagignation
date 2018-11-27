package com.example.bhagyantbiradar.kotlincodechallenge.activities.movie_details

import com.example.bhagyantbiradar.kotlincodechallenge.BaseContract

interface MovieDetailsContract {

    interface View : BaseContract.View {

        /**
         * @author Bhagyawant Biradar
         * to initialize the views
         */
        fun initView()

    }

    interface Presenter : BaseContract.Presenter<MovieDetailsContract.View> {

    }

    interface Model{

    }
}