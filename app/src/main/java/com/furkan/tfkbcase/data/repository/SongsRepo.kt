package com.furkan.tfkbcase.data.repository

import com.furkan.tfkbcase.base.BaseRepository
import com.furkan.tfkbcase.data.api.ApiServices
import com.furkan.tfkbcase.data.local.SongDao
import com.furkan.tfkbcase.data.local.SongDataBase
import com.furkan.tfkbcase.data.local.Songs
import com.furkan.tfkbcase.data.model.SongModel
import retrofit2.Response
import javax.inject.Inject

class SongsRepo @Inject constructor(
    private val apiService: ApiServices,
    private val songDao: SongDao
    ) : BaseRepository() {

    suspend fun insertSong(song: Songs) = songDao.addSong(song)

    suspend fun getData(
        keyword: String, offset: Int, limit : Int
    ) = safeApiRequest {
        apiService.getData(keyword, offset, limit)
    }
}