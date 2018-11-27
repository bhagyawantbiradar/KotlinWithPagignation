package com.example.bhagyantbiradar.kotlincodechallenge.interfaces

import android.arch.persistence.room.*
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search

@Dao
interface MovieDao {
    @Insert
    fun insertMovie(search: Search)

    @Update
    fun updateMovie(search: Search)

    @Delete
    fun deleteMovie(search: Search)

    @Query("SELECT * from Movie")
    fun getAllMovies(): List<Search>

    @Query("DELETE FROM MOVIE")
    fun deleteAllMovies()
}