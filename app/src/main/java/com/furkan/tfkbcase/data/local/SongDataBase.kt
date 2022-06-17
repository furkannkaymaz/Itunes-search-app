package com.furkan.tfkbcase.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Songs::class],
    version = 1
)
abstract class SongDataBase: RoomDatabase() {

    abstract fun getSongDao(): SongDao

    companion object{
        private var instance: SongDataBase? = null

        fun getBookDatabase(context: Context): SongDataBase?{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    SongDataBase::class.java,
                    "book.db").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}