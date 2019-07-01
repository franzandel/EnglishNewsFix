package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.network.NewsNetworkService
import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @Provides
    @ActivityScope
    internal fun provideNewsActivity(newsActivity: NewsActivity): NewsContract.View {
        return newsActivity
    }

    @Provides
    @ActivityScope
    internal fun provideNavigationController(newsActivity: NewsActivity): ActivityNavigation {
        return ActivityNavigation(newsActivity)
    }

    @Provides
    @ActivityScope
    fun provideNewsPresenter(mEnglishNewsRepository: EnglishNewsRepository): NewsPresenter {
        return NewsPresenter(mEnglishNewsRepository)
    }

    @Provides
    @ActivityScope
    internal fun provideEnglishNewsRepository(newsNetworkService: NewsNetworkService) : EnglishNewsRepository {
        return EnglishNewsRepository(newsNetworkService)
    }
}