package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.midterm2.data.User

class MainActivity : ComponentActivity() {
    private val dataLoaderViewModel: DataLoaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataLoaderViewModel.loadUsers()
        dataLoaderViewModel.userList.observe(this) { userList ->
            setContent {
                UserList(userList = userList)
            }
        }
    }
}

@Composable
fun UserList(userList: List<User>) {
    LazyColumn {
        items(userList) { user ->
            UserCard(user)
        }
    }
}

@Composable
fun UserCard(user: User) {
    Column {
        Text(text = user.name.first, style = MaterialTheme.typography.h5)
        Text(text = user.email, style = MaterialTheme.typography.subtitle1)
        Text(text = user.nat, style = MaterialTheme.typography.subtitle1)
    }
}