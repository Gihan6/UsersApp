package com.gihan.usersapp

import com.gihan.usersapp.Users.data.remoteDatabase.ApiService
import com.gihan.usersapp.Users.data.remoteDatabase.UserResponse.Users

class FakeApiService:ApiService {
    override suspend fun getUsers(): List<Users> {
        TODO("Not yet implemented")
    }
}