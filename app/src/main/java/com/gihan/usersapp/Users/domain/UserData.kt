package com.gihan.usersapp.Users.domain

data class UserData(
    val id: Int,
    val name: String,
    val address: String,
    val phone: String,
    val companyName: String,
    var isLike: Boolean = false
)
