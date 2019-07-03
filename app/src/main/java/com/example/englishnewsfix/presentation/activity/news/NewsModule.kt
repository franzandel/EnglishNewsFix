package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.external.AppSchedulerProvider
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @Provides
    @ActivityScope
    internal fun provideNavigationController(newsActivity: NewsActivity): ActivityNavigation {
        return ActivityNavigation(newsActivity)
    }

    @Provides
    @ActivityScope
    fun provideNewsPresenter(mEnglishNewsRepository: EnglishNewsRepository,
                             appSchedulerProvider: AppSchedulerProvider
                            ): NewsPresenter {
        return NewsPresenter(mEnglishNewsRepository, appSchedulerProvider)
    }

    @Provides
    @ActivityScope
    fun provideNewsAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter()
    }
}