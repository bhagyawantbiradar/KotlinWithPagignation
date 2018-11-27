package com.example.bhagyantbiradar.kotlincodechallenge

interface BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {

    }
}