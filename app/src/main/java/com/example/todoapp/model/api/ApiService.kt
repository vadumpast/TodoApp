package com.example.todoapp.model.api

import com.example.todoapp.model.entity.api.UserCredentials
import com.example.todoapp.model.entity.api.UserInfo
import retrofit2.http.POST

interface ApiService {

    @POST(Api.REGISTER_USER)
    fun registerUser(userInfo: UserInfo)

    @POST(Api.LOGIN)
    fun login(userCredentials: UserCredentials)

}