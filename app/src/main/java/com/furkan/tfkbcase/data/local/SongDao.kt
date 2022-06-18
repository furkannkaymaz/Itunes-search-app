package com.furkan.tfkbcase.data.local

import androidx.room.*

@Dao
interface SongDao {

    @Query("SELECT * FROM song_table ORDER BY artistId DESC")
    fun getAllSong(): List<Songs>

    @Insert
    suspend fun addSong(song: Songs)

    @Update
    suspend fun update(song: Songs)

    @Delete
    suspend fun delete(song: Songs)

    @Query("DELETE FROM song_table")
     fun deleteAll()

}