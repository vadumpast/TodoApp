package com.example.todoapp.model.entity.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("password")
    @Expose
    var password: String,
)
