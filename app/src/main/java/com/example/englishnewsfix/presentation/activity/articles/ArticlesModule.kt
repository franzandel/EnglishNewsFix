package com.example.englishnewsfix.presentation.activity.articles

import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.external.AppSchedulerProvider
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {
    @Provides
    @ActivityScope
    internal fun provideNavigationController(articlesActivity: ArticlesActivity): ActivityNavigation {
        return ActivityNavigation(articlesActivity)
    }

    @Provides
    @ActivityScope
    fun provideArticlesPresenter(appSchedulerProvider: AppSchedulerProvider): ArticlesPresenter {
        return ArticlesPresenter(appSchedulerProvider)
    }

    @Provides
    @ActivityScope
    fun provideArticlesAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter()
    }
}