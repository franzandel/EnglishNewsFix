package com.example.englishnewsfix.englishNews.news.di.module

import android.content.Context
import com.example.englishnewsfix.englishNews.news.data.repository.NewsDataStore
import com.example.englishnewsfix.englishNews.news.domain.router.NewsRouter
import com.example.englishnewsfix.base.di.scope.ActivityScope
import com.example.englishnewsfix.base.external.scheduler.AppSchedulerProvider
import com.example.englishnewsfix.englishNews.news.presentation.activity.presenter.NewsPresenter
import com.example.englishnewsfix.base.presentation.router.ScreenRouter
import com.example.englishnewsfix.englishNews.news.data.network.NewsNetworkService
import com.example.englishnewsfix.englishNews.news.domain.usecase.NewsInteractor
import com.example.englishnewsfix.englishNews.news.domain.usecase.NewsUseCase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @Provides
    @ActivityScope
    fun provideNewsPresenter(newsUseCase: NewsUseCase,
                             appSchedulerProvider: AppSchedulerProvider
    ): NewsPresenter {
        return NewsPresenter(
            newsUseCase,
            appSchedulerProvider
        )
    }

    @Provides
    @ActivityScope
    fun provideNewsUseCase(newsDataStore: NewsDataStore): NewsUseCase = NewsInteractor(newsDataStore)

    @Provides
    @ActivityScope
    fun provideNewsDataStore(newsNetworkService: NewsNetworkService): NewsDataStore = NewsDataStore(newsNetworkService)

    @Provides
    @ActivityScope
    fun provideNewsAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter()
    }

    @Provides
    @ActivityScope
    fun provideNewsRouter(mRouter: ScreenRouter,
                          mContext: Context
                         ): NewsRouter {
        return NewsRouter(mRouter, mContext)
    }
}