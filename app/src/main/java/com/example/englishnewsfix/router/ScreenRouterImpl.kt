package com.example.englishnewsfix.router

import android.content.Context
import android.content.Intent
import com.example.englishnews.articles.presentation.activity.view.ArticlesActivity
import com.example.base.presentation.router.ScreenRouter

/**
 * Screen Route*/
class ScreenRouterImpl : ScreenRouter {

    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.Articles.ArticlesScreen -> ArticlesActivity::class.java
            else -> null
        }
        return if (c == null) null else Intent(context, c)
    }
}