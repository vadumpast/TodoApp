package com.example.todoapp.features.login

import com.example.todoapp.base.BaseContract

interface LoginContract: BaseContract {

    fun getEmail(): String

    fun getPassword(): String

    fun openRegisterFragment()

    fun openHomeFragment()
}