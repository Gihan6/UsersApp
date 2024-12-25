package com.gihan.usersapp.Users.prsentation.userList

import com.gihan.usersapp.Users.domain.UserData

data class ScreenUsersState( val users:List<UserData>,
                             val isLoading: Boolean,
                             val error: String?)
