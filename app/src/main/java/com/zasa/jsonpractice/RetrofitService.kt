package com.zasa.jsonpractice

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Sangeeth Amirthanathan
 * on 10/20/2022.
 */
interface RetrofitService {

    @GET("posts")
    fun getPosts() : Call<PostResult>

}