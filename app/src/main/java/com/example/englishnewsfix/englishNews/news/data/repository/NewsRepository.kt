package com.example.englishnewsfix.englishNews.news.data.repository

import com.example.englishnewsfix.englishNews.news.data.response.News
import io.reactivex.Flowable

interface NewsRepository {
    fun getNewsRepo(apiKey: String): Flowable<News>

    fun requestAPIKey(): String
}