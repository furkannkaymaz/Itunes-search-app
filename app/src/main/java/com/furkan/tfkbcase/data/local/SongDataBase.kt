package com.furkan.tfkbcase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Songs::class],
    version = 1
)
abstract class SongDataBase: RoomDatabase() {

    abstract fun getSongDao(): SongDao

}