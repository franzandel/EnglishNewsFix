package com.example.englishnewsfix.data.network

import com.example.englishnewsfix.data.entities.News
import io.reactivex.Flowable
import retrofit2.http.*

interface NewsNetworkService {
    companion object {
        const val API_KEY = "f79d6965f8814037b1412eb6451944ba"
    }

//    @GET("/v2/top-headlines?country=us&category=business")
////    fun getAllNews(@Header("X-Auth-Token") authToken: String, @Header("Authorization") auth: String): Flowable<List<News>>
//    fun getAllNews(@Query("api_key") authToken: String): Flowable<List<News>>

    //must not have replace block. For dynamic query parameters use @Query
//    @GET("/v2/top-headlines?country=us&category=business&apiKey={api_key}")
//    fun getAllNews(@Path("api_key") api_key: String): Flowable<List<News>>

    //must not have replace block. For dynamic query parameters use @Query
//    @GET("/v2/top-headlines?country=us&category=business&apiKey={api_key}")
//    fun getAllNews(@Query("api_key") api_key: String): Flowable<List<News>>

    @GET("/v2/top-headlines?country=us&category=business")
    fun getAllNews(@Query("apiKey") apiKey: String): Flowable<News>
}
