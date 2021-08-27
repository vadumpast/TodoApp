package com.example.todoapp.features.register

import com.example.todoapp.base.BaseContract

interface RegisterContract: BaseContract {

    fun getName(): String

    fun getEmail(): String

    fun getPassword(): String

    fun getAge(): String

    fun openHomeFragment()

}