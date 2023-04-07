package com.example.moviez.data.local.fav

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviez.app.entity.FavMovieItem

@Database(entities = [FavMovieItem::class], version = 1, exportSchema = false)
abstract class FavDatabase : RoomDatabase() {
    abstract fun favDao(): FavDao
}