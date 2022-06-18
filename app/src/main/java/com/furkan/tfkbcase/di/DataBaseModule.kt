package com.furkan.tfkbcase.di

import android.content.Context
import androidx.room.Room
import com.furkan.tfkbcase.data.local.SongDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule{

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        SongDataBase::class.java,
        "song_database"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: SongDataBase) = db.getSongDao() // The reason we can implement a Dao for the database
}


