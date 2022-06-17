package com.furkan.tfkbcase.data.local

import androidx.room.*

@Dao
interface SongDao {
    @Insert
    fun addBook(song: Songs)

    @Query("SELECT * FROM song_table ORDER BY artistId DESC")
    fun getAllBook(): List<Songs>

    @Update
    fun update(song: Songs)

    @Delete
    fun delete(song: Songs)

    @Query("DELETE FROM song_table")
    fun deleteAll()

}