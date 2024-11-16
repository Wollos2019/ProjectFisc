package com.example.easyfiscv2.api

import com.example.easyfiscv2.models.DataModel
import com.example.easyfiscv2.models.DataModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppScriptAPi {
    @GET("macros/echo?")
    suspend fun getClients(
        @Query("user_content_key") appScriptKey : String,
        @Query("lib") lib : String
    ) : Response<DataModel>

    //@GET()
    //suspend fun getClients() : Response<DataModelItem>

    @GET("macros/echo?")
    suspend fun getContacts(
        @Query("user_content_key") appScriptKey: String,
        @Query("lib") lib : String
    ) : List<DataModelItem>
}