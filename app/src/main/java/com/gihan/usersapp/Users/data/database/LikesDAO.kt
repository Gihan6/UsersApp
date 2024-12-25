package com.gihan.usersapp.Users.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LikesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLike(like: Like)

    @Query("SELECT * FROM likes")
    suspend fun getAllLikes(): List<Like>




}