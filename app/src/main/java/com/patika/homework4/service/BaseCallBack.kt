package com.patika.homework4.service

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseCallBack<T> : Callback<T>, BaseResponseHandlerInterface<T>{
    override fun onResponse(call: Call<T>, response: Response<T>) {

        if(response.isSuccessful){

            response.body()?.let {
                onSuccess(it)
            } ?: run {
                onFailure()
            }
        } else{
            onFailure()
        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure()
    }

    abstract override fun onSuccess(data: T)

    abstract override fun onFailure()


}