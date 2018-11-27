package com.example.bhagyantbiradar.kotlincodechallenge.utils

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.bhagyantbiradar.kotlincodechallenge.interfaces.MovieDao
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search


@Database(entities = arrayOf(Search::class), version = 1)
abstract class MovieDatabase : RoomDatabase() {

    companion object {
        private var instance: MovieDatabase? = null
        @Synchronized
        fun getInstance(context: Context): MovieDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, MovieDatabase::class.java, "movie-database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as MovieDatabase
        }

    }

    abstract fun movieDao(): MovieDao


}