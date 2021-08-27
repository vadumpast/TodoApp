package com.example.todoapp.features.login

import android.util.Log
import android.widget.Toast
import com.example.todoapp.R
import com.example.todoapp.app.App
import com.example.todoapp.base.BasePresenter
import com.example.todoapp.model.api.Api
import retrofit2.Retrofit
import com.example.todoapp.model.api.ApiService
import com.example.todoapp.model.entity.api.LoginData
import com.example.todoapp.model.entity.api.RegisterData
import com.example.todoapp.model.entity.api.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class LoginPresenter @Inject constructor(private val apiService: ApiService): BasePresenter<LoginContract>() {

    fun onButtonLoginClicked(){

        val loginData = LoginData(rootView?.getEmail().toString(), rootView?.getPassword().toString())

        apiService.login(loginData).enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                val body = response.body()
                Toast.makeText(App.context, call.request().body.toString(), Toast.LENGTH_SHORT).show()
                if(body?.token.isNullOrEmpty()){
                    Toast.makeText(App.context, App.context.getString(R.string.incorrect_data), Toast.LENGTH_SHORT).show()
                }else {
                    rootView?.openHomeFragment()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(App.context, App.context.getString(R.string.connection_error), Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun onButtonNoAccountClicked(){
        rootView?.openRegisterFragment()
    }
}