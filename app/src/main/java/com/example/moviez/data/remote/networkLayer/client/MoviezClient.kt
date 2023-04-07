package com.example.moviez.data.remote.networkLayer.client


import com.example.moviez.BuildConfig
import retrofit2.Retrofit

class MoviezClient (retrofitBuilder: Retrofit.Builder) : NetworkClient(retrofitBuilder) {

    override val baseUrl = BuildConfig.MOVIEZ_BASE_URL
}