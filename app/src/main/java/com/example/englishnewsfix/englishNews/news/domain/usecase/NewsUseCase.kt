package com.example.englishnewsfix.englishNews.news.domain.usecase

import com.example.englishnewsfix.englishNews.news.data.response.News
import io.reactivex.Flowable

interface NewsUseCase {
    fun getNewsRepo(apiKey: String): Flowable<News>
    fun requestAPIKey(): String
}