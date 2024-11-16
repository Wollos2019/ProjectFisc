package com.example.easyfiscv2.api

import com.example.easyfiscv2.models.DataModelItem
import com.example.easyfiscv2.models.Operation
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("macros/echo?")
    suspend fun getUsers(
        @Query("user_content_key=") appScriptKey : String,
        @Query("lib=") lib : String
    ): List<DataModelItem>

    @GET("posts/{num}")
    suspend fun getPostById(@Path("num") num : Int): Response<Operation>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId : Int): Response<MutableList<Operation>>

    @POST("posts")
    suspend fun createPost(@Body post: Operation): Response<Operation>
}