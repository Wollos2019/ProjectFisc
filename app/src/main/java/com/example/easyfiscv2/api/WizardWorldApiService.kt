package com.example.easyfiscv2.api

import com.example.easyfiscv2.models.House
import retrofit2.http.GET

interface WizardWorldApiService {
    @GET("/Houses")
    suspend fun getHouses(): List<House>
}