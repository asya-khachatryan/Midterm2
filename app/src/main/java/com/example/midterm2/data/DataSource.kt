package com.example.midterm2.data

class Datasource {
    suspend fun loadUsers(): List<User> {
        return RetrofitHelper.getInstance().create(UserApiService::class.java).loadUsers().run{
            this.map {
                User(Name(it.name.title, it.name.first, it.name.last), it.email, it.nat)
            }
        }
    }
}