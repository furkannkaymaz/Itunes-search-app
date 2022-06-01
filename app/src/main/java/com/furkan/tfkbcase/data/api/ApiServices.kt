package com.furkan.tfkbcase.data.api

import com.furkan.tfkbcase.data.model.SongModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("search")
    suspend fun getData(@Query("term") keyword: String,@Query("offset") offset: Int, @Query("limit") limit: Int): Response<SongModel>

}