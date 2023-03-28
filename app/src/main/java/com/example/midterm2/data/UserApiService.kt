package com.example.midterm2.data

import com.example.midterm2.util.Constants.Companion.URI
import retrofit2.Response
import retrofit2.http.GET

interface UserApiService {
    @GET(URI)
    suspend fun loadNews(): Response<NewsResponse>
}