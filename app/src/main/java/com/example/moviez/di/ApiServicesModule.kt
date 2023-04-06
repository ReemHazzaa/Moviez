package com.example.moviez.di

import com.example.data.remote.apiService.MoviezApiService
import com.example.data.remote.networkLayer.client.MoviezClient
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