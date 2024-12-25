package com.gihan.usersapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.gihan.usersapp.Users.domain.UserData
import com.gihan.usersapp.Users.prsentation.userList.ScreenUsersState
import com.gihan.usersapp.Users.prsentation.userList.UsersScreen
import com.gihan.usersapp.ui.theme.UsersAppTheme
import org.junit.Rule
import org.junit.Test

class UserScreenTest {

    @get:Rule
    val testRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun loadingState_isActive() {
        testRule.setContent {
            UsersAppTheme {
                UsersScreen(state = ScreenUsersState(
                    emptyList(), true, null
                ), onLikeClick = { _: Int, _: Boolean -> })
            }
        }
        testRule.onNodeWithContentDescription(SemanticDescription.Users_LIST_LOADING)
            .assertIsDisplayed()

    }

    @Test
    fun loadContentState_isActive() {
        val usersList = getDummyUsersData()
        testRule.setContent {
            UsersScreen(
                state = ScreenUsersState(usersList, false, null),
                onLikeClick = { _: Int, _: Boolean -> })
        }
        testRule.onNodeWithText(usersList[0].name).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticDescription.Users_LIST_LOADING)
            .assertIsNotDisplayed()
    }


    @Test
    fun errorState_isActive() {
        val errorMessage = "Sorry Some Error happen"
        testRule.setContent {
            UsersScreen(
                state = ScreenUsersState(emptyList(), false, errorMessage),
                onLikeClick = { _: Int, _: Boolean -> })
        }
        testRule.onNodeWithText(errorMessage).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticDescription.Users_LIST_LOADING)
            .assertIsNotDisplayed()


    }
    private fun getDummyUsersData():List<UserData>{
        return listOf(
            UserData(1, "Gihan", "A", "012","ABC",false),
            UserData(2, "Gi", "A", "012","ABC",false),

            )
    }
}