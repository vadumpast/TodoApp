package com.example.todoapp.features.register

import android.util.Log
import com.example.todoapp.base.BasePresenter
import com.example.todoapp.model.api.ApiService
import com.example.todoapp.model.entity.api.ApiResponse
import com.example.todoapp.model.entity.api.LoginData
import com.example.todoapp.model.entity.api.RegisterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val apiService: ApiService): BasePresenter<RegisterFragment>() {

    fun onRegisterButtonClicked(){
        
        val registerData = RegisterData(
            rootView?.getName().toString(),
            rootView?.getEmail().toString(),
            rootView?.getPassword().toString(),
            rootView?.getAge().toString()
        )

        apiService.register(registerData).enqueue(object : Callback<ApiResponse> {
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

}