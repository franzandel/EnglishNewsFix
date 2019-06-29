package com.example.englishnewsfix.di.module.builder

import com.example.englishnewsfix.presentation.activity.news.NewsModule
import com.example.englishnewsfix.di.scope.ActivityScope
import com.example.englishnewsfix.presentation.activity.news.NewsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Please provide all activity in this call for activity builder with DI
 */
@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(NewsModule::class),
        (CommonFragmentBuilder::class)])
    internal abstract fun bindNewsActivity(): NewsActivity
}