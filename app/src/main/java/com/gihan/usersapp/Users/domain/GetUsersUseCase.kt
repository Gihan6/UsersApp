package com.gihan.usersapp.Users.domain

import com.gihan.usersapp.Users.data.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val gymsRepository: UserRepository,
) {
    suspend operator fun invoke(): List<UserData> {
        val users = gymsRepository.loadUsers()
        return users.sortedBy { it.name }.map {
            UserData(
                it.id ?: 0,
                it.name ?: "",
                buildString {
                    append(it.address?.city)
                    append(" - ")
                    append(it.address?.street)
                },
                it.phone ?: "",
                it.company?.name ?: ""

            )
        }
    }
}