package com.example.moviez.app.di

import com.example.moviez.data.remote.apiService.MoviezApiService
import com.example.moviez.data.remote.networkLayer.client.MoviezClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {

    @Provides
    @Singleton
    fun provideMoviezApiService(moviezClient: MoviezClient): MoviezApiService {
        return moviezClient.build().create(MoviezApiService::class.java)
    }

}