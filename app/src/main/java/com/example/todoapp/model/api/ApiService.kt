package com.example.todoapp.model.api

import com.example.todoapp.model.entity.api.UserCredentials
import com.example.todoapp.model.entity.api.UserInfo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Api.REGISTER_USER)
    fun registerUser(userInfo: UserInfo)

    @POST(Api.LOGIN)
    fun login(
        @Body userCredentials: UserCredentials
    ) : Call<ResponseBody>
}
