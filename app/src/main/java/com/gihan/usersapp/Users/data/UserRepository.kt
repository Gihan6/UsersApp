package com.gihan.usersapp.Users.data

import com.gihan.usersapp.Users.data.database.Like
import com.gihan.usersapp.Users.data.database.LikesDAO
import com.gihan.usersapp.Users.data.di.IODispatcher
import com.gihan.usersapp.Users.data.remoteDatabase.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private var database: LikesDAO,
    private var apiService: ApiService,
    @IODispatcher private var dispatcher: CoroutineDispatcher
) {


    suspend fun loadUsers() = withContext(dispatcher) {
        try {
            apiService.getUsers()
        } catch (e: Exception) {
            throw Exception("There is no data found please try to connect to internet ")
        }
        //make sort  as business logic

    }

    suspend fun saveLikeLocal(userId: Int, state: Boolean) =
        withContext(dispatcher) {
            database.saveLike(Like(userId, state))
            return@withContext database.getAllLikes()
        }

    suspend fun getAllLikedUser() =
        withContext(dispatcher) {
            return@withContext database.getAllLikes()

        }

}