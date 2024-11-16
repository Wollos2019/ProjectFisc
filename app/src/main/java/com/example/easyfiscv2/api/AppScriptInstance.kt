package com.example.easyfiscv2.api

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object AppScriptInstance {
    private const val BASEURL = "https://script.googleusercontent.com/"
    //private const val BASEURL = "https://script.google.com/macros/s/AKfycbw-NEhFBxK_CjJnl1MHyLmpljujmNuqInmF4FtiusOvxl3LptVk3a3GIPB4Lr5aKqbc/exec"
    private fun getInstance() : Retrofit {
        return Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val appScriptApi : AppScriptAPi = getInstance().create(AppScriptAPi::class.java)
}