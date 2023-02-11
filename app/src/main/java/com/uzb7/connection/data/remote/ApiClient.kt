package com.uzb7.connection.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val isTester = false
    val SERVER_PRODUCTION = "https://jsonplaceholder.typicode.com/"
    val SERVER_DEVELOPMENT = "https://jsonplaceholder.typicode.com/"

    val retrofit = Retrofit.Builder().baseUrl(baseURL())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun baseURL(): String {
        if (isTester) return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val apiService= retrofit.create(ApiServis::class.java)



}
