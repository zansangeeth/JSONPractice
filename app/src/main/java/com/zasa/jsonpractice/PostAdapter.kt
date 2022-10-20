package com.zasa.jsonpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sangeeth Amirthanathan
 * on 10/20/2022.
 */
open class PostAdapter(val context: Context, val posts: List<PostResultItem>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bindPost(post)
    }

    override fun getItemCount() = posts.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindPost(post: PostResultItem) {
            itemView.findViewById<TextView>(R.id.tvTitle).text = post.title
            itemView.findViewById<TextView>(R.id.tvDesc).text = post.body
        }

    }
}