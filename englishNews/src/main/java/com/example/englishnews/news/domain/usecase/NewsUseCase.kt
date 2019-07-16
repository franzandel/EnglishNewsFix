package com.example.englishnews.news.domain.usecase

import com.example.feature.news.data.response.News
import io.reactivex.Flowable

interface NewsUseCase {
    fun getNewsRepo(apiKey: String): Flowable<News>
}