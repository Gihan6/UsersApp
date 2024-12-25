package com.gihan.usersapp.Users.prsentation.userList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gihan.usersapp.R
import com.gihan.usersapp.SemanticDescription
import com.gihan.usersapp.Users.domain.UserData
import com.gihan.usersapp.ui.theme.UsersAppTheme

@Composable
fun UsersScreen(
    state: ScreenUsersState,
    onLikeClick: (Int, Boolean) -> Unit
) {

    UsersAppTheme {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 30.dp)) {
                items(state.users) { user ->
                    UserItem(

                        user = user,
                        onLikeUserClick = { id, oldValue -> onLikeClick(id, oldValue) }
                    )
                }
            }
            if (state.isLoading) CircularProgressIndicator(
                modifier = Modifier.semantics {
                    this.contentDescription = SemanticDescription.Users_LIST_LOADING
                }
            )
            state.error?.let { error ->
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.Center),
                    text = error,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

@Composable
fun UserItem(
    user: UserData,
    onLikeUserClick: (itemId: Int, Boolean) -> Unit,

    ) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

        ) {

        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = colorResource(id = R.color.purple_200)
                )
                Row {
                    Image(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "phone Icon",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = user.phone,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )


                }

                Row {
                    Image(
                        imageVector = Icons.Filled.Place,
                        contentDescription = "place Icon",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = user.address,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )


                }

                Row {
                    Image(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "place Icon",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = user.companyName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )


                }
            }
            val likeIcon =
                if (user.isLike) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

            Image(
                imageVector = likeIcon,
                contentDescription = "Like Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {
                        onLikeUserClick(user.id, user.isLike)
                    }
                )

        }


    }
}