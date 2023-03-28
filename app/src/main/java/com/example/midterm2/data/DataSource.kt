package com.example.midterm2.data

class Datasource {
    suspend fun loadUsers(): List<User> {
        return RetrofitHelper.getInstance().create(UserApiService::class.java).loadUsers()
    }
}