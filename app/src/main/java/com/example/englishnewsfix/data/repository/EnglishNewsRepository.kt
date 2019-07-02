package com.example.englishnewsfix.data.repository

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.data.network.NewsNetworkService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EnglishNewsRepository
@Inject constructor(private var newsNetworkService: NewsNetworkService
                    ) {

    /**
     * Get News Data
     * @Param mXauth
     */
    fun getNewsRepo(mXauth: String): Flowable<News> {
        return newsNetworkService.getAllNews(mXauth)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun requestAPIKey(): String {
        return NewsNetworkService.API_KEY
    }
}
