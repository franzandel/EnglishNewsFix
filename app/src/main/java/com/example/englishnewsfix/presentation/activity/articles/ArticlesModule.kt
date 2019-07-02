package com.example.englishnewsfix.presentation.activity.articles

import com.example.englishnewsfix.data.network.NewsNetworkService
import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {
    @Provides
    @ActivityScope
    internal fun provideArticlesActivity(articlesActivity: ArticlesActivity): ArticlesContract.View {
        return articlesActivity
    }

    @Provides
    @ActivityScope
    internal fun provideNavigationController(articlesActivity: ArticlesActivity): ActivityNavigation {
        return ActivityNavigation(articlesActivity)
    }

    @Provides
    @ActivityScope
    fun provideArticlesPresenter(): ArticlesPresenter {
        return ArticlesPresenter()
    }

    @Provides
    @ActivityScope
    fun provideArticlesAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter<ViewHolder>()
    }
}