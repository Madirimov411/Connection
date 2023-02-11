package com.uzb7.connection.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzb7.connection.R
import com.uzb7.connection.adapter.PostAdapter
import com.uzb7.connection.data.remote.ApiClient
import com.uzb7.connection.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
     var list= ArrayList<Post>()
    lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        loadPosts()

        val rvPost=findViewById<RecyclerView>(R.id.rvPost)
        adapter=PostAdapter(list)
        rvPost.adapter=adapter
        rvPost.layoutManager=GridLayoutManager(this,1)

    }

    private fun loadPosts() {
        ApiClient.apiService.getAllPosts().enqueue(object :Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                if(response.isSuccessful) {
                    list=response.body() as ArrayList<Post>
                    adapter.submitList(list)
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }

        })
    }


}