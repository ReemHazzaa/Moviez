package com.example.moviez.di

import com.example.data.remote.networkLayer.client.MoviezClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientsModule {

    @Provides
    @Singleton
    fun provideMoviezNetworkClient(retrofitBuilder: Retrofit.Builder): MoviezClient {
        return MoviezClient(retrofitBuilder)
    }

}