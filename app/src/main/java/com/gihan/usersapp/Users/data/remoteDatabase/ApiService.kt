package com.gihan.usersapp.Users.data.remoteDatabase

import com.gihan.usersapp.Users.data.remoteDatabase.UserResponse.Users
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>
}