package com.gihan.usersapp.Users.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("likes")

data class Like(
    @PrimaryKey
    val userId:Int,
    val isLike:Boolean)
