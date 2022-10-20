package com.zasa.jsonpractice

import com.zasa.jsonpractice.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sangeeth Amirthanathan
 * on 10/20/2022.
 */
object RetrofitCall {

    val retrofitCall =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

}