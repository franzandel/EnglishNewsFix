package com.example.englishnewsfix.presentation.activity.articles

import com.example.englishnewsfix.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [(ArticlesModule::class)])
interface ArticlesComponent : AndroidInjector<ArticlesActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ArticlesActivity>()
}