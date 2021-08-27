package com.example.todoapp.model.entity.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo(

    @SerializedName("age")
    @Expose
    var age: Int,

    @SerializedName("_id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("createdAt")
    @Expose
    var createdAt: String,

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String,

    @SerializedName("__v")
    @Expose
    var v: Int,
)
