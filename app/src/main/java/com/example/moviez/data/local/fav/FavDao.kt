package com.example.moviez.data.local.fav

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviez.app.entity.FavMovieItem

@Dao
interface FavDao {
    @Query("SELECT * FROM favorites_table")
    suspend fun getAllFav(): LiveData<List<FavMovieItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(item: FavMovieItem)
}