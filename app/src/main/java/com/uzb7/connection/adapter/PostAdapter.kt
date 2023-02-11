package com.uzb7.connection.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uzb7.connection.R
import com.uzb7.connection.model.Post

class PostAdapter(val list: ArrayList<Post>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {




    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle=view.findViewById<TextView>(R.id.tvTitle)
        val tvBody=view.findViewById<TextView>(R.id.tvBody)


    }

    fun submitList(newList:ArrayList<Post>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=list[position]
        holder.apply {
            tvTitle.text=post.title
            tvBody.text=post.body
        }
    }
}