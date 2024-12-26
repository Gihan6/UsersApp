package com.gihan.usersapp

import com.gihan.usersapp.Users.data.UserRepository
import com.gihan.usersapp.Users.domain.GetUsersUseCase
import com.gihan.usersapp.Users.domain.SaveLikeForUserUseCase
import com.gihan.usersapp.Users.domain.SetLikeToRemoteUsersUseCase
import com.gihan.usersapp.Users.prsentation.userList.ScreenUsersState
import com.gihan.usersapp.Users.prsentation.userList.ViewModelUsers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class ViewModelUsersTest {
    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @Test
    fun loadingState_isSetCorrectly() = scope.runTest {
        val viewModel = getViewModel()
        val state = viewModel.getUsersState()
        assert(state == ScreenUsersState(emptyList(), true, null))
    }

    private fun getViewModel(): ViewModelUsers {

        val usersRepository = UserRepository(FakeDataBase(), FakeApiService(), dispatcher)
        val getUsersUseCase = GetUsersUseCase(usersRepository)
        val setLikeToRemoteUsersUseCase =
            SetLikeToRemoteUsersUseCase(usersRepository, getUsersUseCase)
        val saveLikeForUserUseCase = SaveLikeForUserUseCase(usersRepository, getUsersUseCase)
        return ViewModelUsers(setLikeToRemoteUsersUseCase, saveLikeForUserUseCase, dispatcher)
    }
}