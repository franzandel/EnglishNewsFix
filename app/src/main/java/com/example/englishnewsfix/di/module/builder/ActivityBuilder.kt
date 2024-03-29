package com.example.englishnewsfix.di.module.builder

import com.example.base.di.scope.ActivityScope
import com.example.englishnews.articles.presentation.activity.view.ArticlesActivity
import com.example.englishnews.articles.di.module.ArticlesModule
import com.example.englishnews.news.presentation.activity.view.NewsActivity
import com.example.englishnews.news.di.module.NewsModule
import com.example.englishnews.news.di.module.NewsNetworkModule
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