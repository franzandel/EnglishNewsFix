package com.example.englishnewsfix.di.module

import android.app.Application
import android.content.Context
import com.example.englishnewsfix.presentation.activity.news.NewsComponent
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    internal fun gson() = Gson()
}