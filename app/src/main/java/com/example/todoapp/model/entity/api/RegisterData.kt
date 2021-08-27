package com.example.todoapp.model.entity.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterData(

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("password")
    @Expose
    var password: String,

    @SerializedName("age")
    @Expose
    var age: String,

)
