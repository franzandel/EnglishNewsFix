package com.example.englishnewsfix.englishNews.news.domain.router

import android.content.Context
import android.content.Intent
import com.example.englishnewsfix.englishNews.news.data.response.News
import com.example.englishnewsfix.englishNews.news.presentation.activity.contract.NewsContract
import com.example.englishnewsfix.englishNews.news.presentation.activity.view.NewsActivity.Companion.NEWS_KEY
import com.example.englishnewsfix.englishNews.news.presentation.activity.view.NewsActivity.Companion.SOURCE_NAME_KEY
import com.example.englishnewsfix.base.presentation.router.ScreenRouter
import javax.inject.Inject

class NewsRouter @Inject constructor(
    private val mRouter: ScreenRouter,
    private val mContext: Context
) : NewsContract.Router {

    override fun goToArticlesPage(sourceName: String?, news: News) {
        mRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.Articles.ArticlesScreen)?.run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(SOURCE_NAME_KEY, sourceName)
            putExtra(NEWS_KEY, news)
            mContext.startActivity(this)
        }
    }
}