package com.example.englishnewsfix.data.network

import com.example.englishnewsfix.data.entities.News
import io.reactivex.Flowable
import retrofit2.http.*

interface NewsNetworkService {
    companion object {
        const val API_KEY = "f79d6965f8814037b1412eb6451944ba"
    }

    @GET("/v2/top-headlines?country=us&category=business")
    fun getAllNews(@Header("X-Auth-Token") authToken: String): Flowable<List<News>>

    /*@GET("/api/v1/loans/{loanId}")
    fun getNews(@Header("X-Auth-Token") authToken: String, @Header("Authorization") auth: String, @Path("loanId") loanId: String): Flowable<List<Loan>>*/
}
