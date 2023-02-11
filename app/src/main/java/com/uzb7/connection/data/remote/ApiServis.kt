package com.uzb7.connection.data.remote

import com.uzb7.connection.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServis {

    @Headers(
        "Content-type:application/json; charset=UTF-8"
    )

    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id:Int):Call<Post>

    @POST("posts")
    fun savePost(@Body post:Post):Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id:Int,@Body post: Post):Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id:Int)




}