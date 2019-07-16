package com.example.base.di.module

import android.app.Application
import android.content.Context
import com.example.base.di.scope.AppScope
import com.example.base.external.scheduler.AppSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
abstract class BaseModule {

    @Provides
    @AppScope
    fun provideContext(application: Application): Context = application

    @Provides
    @AppScope
    fun provideSchedulerProvider() = AppSchedulerProvider()

}