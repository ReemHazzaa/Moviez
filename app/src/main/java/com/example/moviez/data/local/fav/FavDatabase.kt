package com.example.moviez.data.local.fav

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviez.app.entity.FavMovieItem

@Database(entities = [FavMovieItem::class], version = 1, exportSchema = false)
abstract class FavDatabase : RoomDatabase() {
    abstract fun favDao(): FavDao

    companion object {
        @Volatile
        private var INSTANCE: FavDatabase? = null

        fun getDatabase(context: Context): FavDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FavDatabase::class.java, "fav_database"
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}