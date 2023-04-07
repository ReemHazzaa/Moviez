package com.example.moviez.app.di

import android.content.Context
import androidx.room.Room
import com.example.moviez.data.local.fav.FavDao
import com.example.moviez.data.local.fav.FavDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FavDatabase {
        return Room.databaseBuilder(
            context,
            FavDatabase::class.java,
            "fav_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFavDao(database: FavDatabase): FavDao = database.favDao()
}