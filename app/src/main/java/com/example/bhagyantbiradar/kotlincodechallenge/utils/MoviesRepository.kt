package com.example.bhagyantbiradar.kotlincodechallenge.utils

import android.app.Application
import android.os.AsyncTask
import com.example.bhagyantbiradar.kotlincodechallenge.interfaces.MovieDao
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search


class MoviesRepository(application: Application) {
    private var movieDao: MovieDao? = null
    private var allMovies: List<Search>? = null

    init {
        val database = MovieDatabase.getInstance(application)
        movieDao = database.movieDao()
        allMovies = movieDao!!.getAllMovies()
    }

    fun insertMovie(search: Search) {
        InsertMovieAsyncTask(movieDao!!).execute(search)
    }

    fun updateMovie(search: Search) {
        UpdateMovieAsyncTask(movieDao!!).execute(search)
    }

    fun deleteMovie(search: Search) {
        DeleteMovieAsyncTask(movieDao!!).execute(search)
    }

    fun deleteAllMovies() {
        DeleteAllMoviesAsyncTask(movieDao!!).execute()
    }

    fun getAllMovies() : List<Search>? {
        return allMovies
    }


    private class InsertMovieAsyncTask(private val movieDao: MovieDao) :
        AsyncTask<Search, Void, Void>() {
        override fun doInBackground(vararg search: Search): Void? {
            movieDao.insertMovie(search[0])
            return null
        }
    }

    private class DeleteMovieAsyncTask(private val movieDao: MovieDao) :
        AsyncTask<Search, Void, Void>() {
        override fun doInBackground(vararg search: Search): Void? {
            movieDao.deleteMovie(search[0])
            return null
        }
    }

    private class UpdateMovieAsyncTask(private val movieDao: MovieDao) :
        AsyncTask<Search, Void, Void>() {
        override fun doInBackground(vararg search: Search): Void? {
            movieDao.insertMovie(search[0])
            return null
        }
    }

    private class DeleteAllMoviesAsyncTask(private val movieDao: MovieDao) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            movieDao.deleteAllMovies()
            return null
        }
    }
}