package com.example.todoapp.model.api

import com.example.todoapp.model.entity.api.LoginData
import com.example.todoapp.model.entity.api.ApiResponse
import com.example.todoapp.model.entity.api.RegisterData
import com.example.todoapp.model.entity.api.UserInfo
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Api.REGISTER_USER)
    fun register(@Body data: RegisterData): Call<ApiResponse>

    @POST(Api.LOGIN)
    fun login(@Body data: LoginData): Call<ApiResponse>

    @GET(Api.LOGIN_BY_TOKEN)
    fun loginByToken(@Header("Authorization") token: String): Call<UserInfo>

}
