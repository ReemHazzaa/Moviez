package com.example.moviez.di


import com.example.data.repo.MoviezRepoImpl
import com.example.domain.repo.MoviezRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviezRepoModule {
    @Binds
    abstract fun provideMoviezRepoModule(moviezRepoModuleImp: MoviezRepoImpl): MoviezRepo
}