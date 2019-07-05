package com.example.englishnewsfix.app.di.module.builder

import com.example.englishnewsfix.base.di.scope.ActivityScope
import com.example.englishnewsfix.englishNews.articles.presentation.activity.view.ArticlesActivity
import com.example.englishnewsfix.englishNews.articles.di.module.ArticlesModule
import com.example.englishnewsfix.englishNews.news.presentation.activity.view.NewsActivity
import com.example.englishnewsfix.englishNews.news.di.module.NewsModule
import com.example.englishnewsfix.englishNews.news.di.module.NewsNetworkModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Please provide all activity in this call for activity builder with DI
 */
@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(NewsModule::class), (NewsNetworkModule::class)])
    internal abstract fun bindNewsActivity(): NewsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ArticlesModule::class)])
    internal abstract fun bindArticlesActivity(): ArticlesActivity
}