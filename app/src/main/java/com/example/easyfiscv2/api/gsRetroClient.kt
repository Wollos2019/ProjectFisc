package com.example.easyfiscv2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object gsRetroClient {
    private const val BASE_URL = "https://script.googleusercontent.com/"

    val gsApiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}