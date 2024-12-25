package com.gihan.usersapp.Users.prsentation.userList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gihan.usersapp.Users.data.di.MainDispatcher
import com.gihan.usersapp.Users.domain.SaveLikeForUserUseCase
import com.gihan.usersapp.Users.domain.SetLikeToRemoteUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelUsers @Inject constructor(
    private val setLikeToRemoteUsersUseCase: SetLikeToRemoteUsersUseCase,
    private val saveLikeForUserUseCase: SaveLikeForUserUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {


    private var userState by mutableStateOf(
        ScreenUsersState(
            users = emptyList(),
            isLoading = true,
            error = null
        )
    )

    fun getUsersState(): ScreenUsersState {
        return userState
    }

    private val errorHandle = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
        userState = userState.copy(isLoading = false, error = throwable.message)

    }


    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch(errorHandle + dispatcher) {
            userState = userState.copy(
                users = setLikeToRemoteUsersUseCase(),
                isLoading = false,
                error = null
            )

        }

    }


    fun setUserLiked(itemId: Int, oldValue: Boolean) {
        viewModelScope.launch(dispatcher) {
            userState = userState.copy(users = saveLikeForUserUseCase(itemId, oldValue))
        }

    }


}