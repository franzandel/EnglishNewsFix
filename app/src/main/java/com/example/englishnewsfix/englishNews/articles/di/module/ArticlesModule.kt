package com.example.englishnewsfix.englishNews.articles.di.module

import com.example.englishnewsfix.base.di.scope.ActivityScope
import com.example.englishnewsfix.base.external.scheduler.AppSchedulerProvider
import com.example.englishnewsfix.englishNews.articles.presentation.activity.presenter.ArticlesPresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {
    @Provides
    @ActivityScope
    fun provideArticlesPresenter(appSchedulerProvider: AppSchedulerProvider): ArticlesPresenter {
        return ArticlesPresenter(
            appSchedulerProvider
        )
    }

    @Provides
    @ActivityScope
    fun provideArticlesAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter()
    }
}