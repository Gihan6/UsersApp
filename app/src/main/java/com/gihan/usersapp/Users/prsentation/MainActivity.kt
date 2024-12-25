package com.gihan.usersapp.Users.prsentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gihan.usersapp.Users.prsentation.userList.UsersScreen
import com.gihan.usersapp.Users.prsentation.userList.ViewModelUsers
import com.gihan.usersapp.ui.theme.UsersAppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UsersAppTheme {
                val vm: ViewModelUsers = hiltViewModel()
                UsersScreen(
                    state = vm.getUsersState(),
                    onLikeClick = { id, oldValue ->
                    vm.setUserLiked(id,oldValue)

                })
            }

        }
    }
}

