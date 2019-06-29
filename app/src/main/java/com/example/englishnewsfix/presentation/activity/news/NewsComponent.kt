package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [(NewsModule::class)])
interface NewsComponent : AndroidInjector<NewsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsActivity>()
}