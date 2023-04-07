package com.example.moviez.app.di


import com.example.moviez.data.repo.MoviezRepoImpl
import com.example.moviez.domain.repo.MoviezRepo
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