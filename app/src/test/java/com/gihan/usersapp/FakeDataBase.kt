package com.gihan.usersapp

import com.gihan.usersapp.Users.data.database.Like
import com.gihan.usersapp.Users.data.database.LikesDAO

class FakeDataBase:LikesDAO {
    override suspend fun saveLike(like: Like) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllLikes(): List<Like> {
        TODO("Not yet implemented")
    }
}