package com.example.englishnewsfix.di.module.builder

import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.presentation.activity.articles.ArticlesActivity
import com.example.englishnewsfix.presentation.activity.articles.ArticlesModule
import com.example.englishnewsfix.presentation.activity.news.NewsActivity
import com.example.englishnewsfix.presentation.activity.news.NewsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Please provide all activity in this call for activity builder with DI
 */
@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(NewsModule::class)])
    internal abstract fun bindNewsActivity(): NewsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ArticlesModule::class)])
    internal abstract fun bindArticlesActivity(): ArticlesActivity
}