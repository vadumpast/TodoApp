package com.example.todoapp.features.login

import android.util.Log
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


class LoginPresenter: BasePresenter<LoginContract>() {

    fun onButtonLoginClicked(){
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        val loginData = LoginData(rootView?.getEmail().toString(), rootView?.getPassword().toString())
        service.login(loginData).enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                val body = response.body()

                Log.d("tagg", "age - " + body?.user?.age.toString())
                Log.d("tagg", "id - " + body?.user?.id.toString())
                Log.d("tagg", "name - " + body?.user?.name.toString())
                Log.d("tagg", "email - " + body?.user?.email.toString())
                Log.d("tagg", "createdAt - " + body?.user?.createdAt.toString())
                Log.d("tagg", "updatedAt - " + body?.user?.updatedAt.toString())
                Log.d("tagg", "v - " + body?.user?.v.toString())
                Log.d("tagg", "token - " + body?.token.toString())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })




    }

    fun onButtonNoAccountClicked(){
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        service.register(RegisterData("vadum", "vadum@gmail.com", "12345678", "17")).enqueue(object : Callback<ApiResponse>{
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                val body = response.body()

                Log.d("tagg", "age - " + body?.user?.age.toString())
                Log.d("tagg", "id - " + body?.user?.id.toString())
                Log.d("tagg", "name - " + body?.user?.name.toString())
                Log.d("tagg", "email - " + body?.user?.email.toString())
                Log.d("tagg", "createdAt - " + body?.user?.createdAt.toString())
                Log.d("tagg", "updatedAt - " + body?.user?.updatedAt.toString())
                Log.d("tagg", "v - " + body?.user?.v.toString())
                Log.d("tagg", "token - " + body?.token.toString())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}