package com.example.todoapp.features.login

import com.example.todoapp.base.BasePresenter
import com.example.todoapp.model.api.ApiService
import com.example.todoapp.model.entity.api.UserCredentials
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Toast
import com.example.todoapp.model.api.Api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import retrofit2.adapter.rxjava2.Result.response

import com.google.gson.Gson
import retrofit2.adapter.rxjava2.Result.response
import retrofit2.http.Body


class LoginPresenter: BasePresenter<LoginContract>() {

    fun onButtonLoginClicked(){


        val gsonFactory = GsonConverterFactory.create()
        val okHttpClient = OkHttpClient()
        val callAdapterFactory = RxJava2CallAdapterFactory.create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()

        val callback = object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()

                    Log.d("tagg", apiResponse!!.byteString().toString())
                } else {
                    Log.d("tagg", "13123 - " + response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        }

        val credentials = UserCredentials("muh.nurali43@gmail.com", "12345678")
        retrofit.create(ApiService::class.java)
            .login(credentials).enqueue(callback)





    }

    fun onButtonNoAccountClicked(){

    }

}