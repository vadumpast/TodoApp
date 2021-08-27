package com.example.todoapp.model.entity.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @SerializedName("user")
    @Expose
    var user: UserInfo,

    @SerializedName("token")
    @Expose
    var token: String,
)
