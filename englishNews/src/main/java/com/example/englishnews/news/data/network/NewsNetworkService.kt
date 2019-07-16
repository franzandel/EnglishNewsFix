package com.example.englishnews.news.data.network

import com.example.feature.news.data.response.News
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsNetworkService {
    @GET("/v2/top-headlines?country=us&category=business")
    fun getAllNews(@Query("apiKey") apiKey: String): Flowable<News>
}
