package com.gihan.usersapp.Users.domain

import com.gihan.usersapp.Users.data.UserRepository
import javax.inject.Inject

class SetLikeToRemoteUsersUseCase @Inject constructor(
    private val repository: UserRepository,
    private val getUsersUseCase: GetUsersUseCase
) {
    suspend operator fun invoke(): List<UserData> {
        val likedUser = repository.getAllLikedUser()
        val allUser = getUsersUseCase()
        likedUser.forEach { like ->
            for (i in 0..allUser.size) {
                if (allUser[i].id == like.userId) {
                    allUser[i].isLike = like.isLike
                    return@forEach
                }
            }
        }
        return allUser


    }
}