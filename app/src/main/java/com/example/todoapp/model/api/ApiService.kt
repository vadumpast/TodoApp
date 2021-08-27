package com.example.todoapp.model.api

import com.example.todoapp.model.entity.api.LoginData
import com.example.todoapp.model.entity.api.ApiResponse
import com.example.todoapp.model.entity.api.RegisterData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("/user/register")
    fun register(@Body data: RegisterData): Call<ApiResponse>

    @POST("/user/login")
    fun login(@Body data: LoginData): Call<ApiResponse>

}
