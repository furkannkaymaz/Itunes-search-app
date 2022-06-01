package com.furkan.tfkbcase.di

import com.furkan.tfkbcase.BuildConfig.BASE_URL
import com.furkan.tfkbcase.data.api.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object ApiClient {

    private val httpBuilder = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    @Singleton
    @Provides
    fun retrofit(): ApiServices = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(httpBuilder.build())
        .build()
        .create(ApiServices::class.java)
}