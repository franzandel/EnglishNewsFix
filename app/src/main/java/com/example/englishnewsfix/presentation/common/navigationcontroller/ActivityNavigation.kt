package com.example.englishnewsfix.presentation.common.navigationcontroller

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.activity.articles.ArticlesActivity
import com.example.englishnewsfix.presentation.activity.news.NewsActivity.Companion.NEWS_KEY
import com.example.englishnewsfix.presentation.activity.news.NewsActivity.Companion.SOURCE_NAME_KEY
import javax.inject.Inject

/**
 * Navigation Controller class handling all routes intent in this app
 * @Param activity as main parameter
 */

class ActivityNavigation @Inject constructor(val activity: AppCompatActivity) {

    /**
     * Intent to Progress Activity
     * */

    fun navigateToArticlesPage(sourceName: String?, news: News) {
        val articlesIntent = newIntent(activity, ArticlesActivity::class.java)
        articlesIntent.apply {
            putExtra(SOURCE_NAME_KEY, sourceName)
            putExtra(NEWS_KEY, news)
        }
        activity.startActivity(articlesIntent)
    }

    /**
     * Intent Common Function
     * Handling new intent
     * */

    private fun <T> newIntent(context: Context, cls: Class<T>): Intent {
        return Intent(context, cls)
    }
}