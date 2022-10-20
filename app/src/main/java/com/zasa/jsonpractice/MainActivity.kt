package com.zasa.jsonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val posts = mutableListOf<PostResultItem>()
    val postAdapter = PostAdapter(this, posts)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonService = RetrofitCall.retrofitCall.create(RetrofitService::class.java)

        jsonService.getPosts().enqueue(object : Callback<PostResult> {
            override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                val body = response.body()
                Log.i(TAG, "response : $body")

                rvPosts.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = postAdapter
                    posts.addAll(body!!)
                    postAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<PostResult>, t: Throwable) {
                Log.i(TAG, "error : $t")
            }

        })
    }
}