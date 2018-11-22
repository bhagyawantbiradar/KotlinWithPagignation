package com.example.bhagyantbiradar.kotlincodechallenge.activities.MovieDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bhagyantbiradar.kotlincodechallenge.R
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsContract.View {

    lateinit var presenter: MovieDetailsContract.Presenter
    override fun initView() {
        val intent = intent
        val movie = intent.getParcelableExtra<Search>("movie")
        tvTitle.text = movie.title
        tvType.text = movie.type
        tvYear.text = movie.year

        Picasso.with(this)
            .load(movie.poster)
            .fit()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(ivPoster)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        presenter = MovieDetailsPresenter(this)
        presenter.subscribe()
        initView()
    }
}
