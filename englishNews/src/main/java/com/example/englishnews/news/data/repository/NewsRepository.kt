package com.example.englishnews.news.data.repository

import com.example.feature.news.data.response.News
import io.reactivex.Flowable

interface NewsRepository {
    fun getNewsRepo(apiKey: String): Flowable<News>
}