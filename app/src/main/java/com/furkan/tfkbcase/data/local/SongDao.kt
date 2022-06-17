package com.furkan.tfkbcase.data.local

import androidx.room.*

@Dao
interface SongDao {
    @Insert
    fun addSong(song: Songs)

    @Query("SELECT * FROM song_table ORDER BY artistId DESC")
    fun getAllSong(): List<Songs>

    @Update
    fun update(song: Songs)

    @Delete
    fun delete(song: Songs)

    @Query("DELETE FROM song_table")
    fun deleteAll()

}