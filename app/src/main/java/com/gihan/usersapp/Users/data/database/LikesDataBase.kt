package com.gihan.usersapp.Users.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Like::class],
    version = 1,
    exportSchema = false
)
abstract class LikesDataBase : RoomDatabase(){
    abstract val dao:LikesDAO
}