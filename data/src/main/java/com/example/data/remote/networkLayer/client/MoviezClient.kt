package com.example.data.remote.networkLayer.client


import com.example.data.BuildConfig
import retrofit2.Retrofit

class MoviezClient (retrofitBuilder: Retrofit.Builder) : NetworkClient(retrofitBuilder) {

    override val baseUrl = BuildConfig.MOVIEZ_BASE_URL
}