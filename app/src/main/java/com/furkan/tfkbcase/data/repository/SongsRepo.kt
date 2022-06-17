package com.furkan.tfkbcase.data.repository

import com.furkan.tfkbcase.base.BaseRepository
import com.furkan.tfkbcase.data.api.ApiServices
import com.furkan.tfkbcase.data.local.SongDataBase
import com.furkan.tfkbcase.data.model.SongModel
import retrofit2.Response
import javax.inject.Inject

class SongsRepo @Inject constructor(
    private val apiService: ApiServices,
    private val songDao: SongDataBase
    ) : BaseRepository() {

    fun getAllSongs() = songDao.getSongDao()

    suspend fun getData(
        keyword: String, offset: Int, limit : Int
    ) = safeApiRequest {
        apiService.getData(keyword, offset, limit)
    }
}