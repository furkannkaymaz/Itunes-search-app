package com.furkan.tfkbcase.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_table")
data class Songs(

    @ColumnInfo(name = "song_name")
    val songName: String,

    @ColumnInfo(name = "author_name")
    val authorName: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artistId")
    var artistId: Int = 0
}