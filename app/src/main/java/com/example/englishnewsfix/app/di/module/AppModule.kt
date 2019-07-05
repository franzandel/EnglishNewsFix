package com.example.englishnewsfix.app.di.module

import com.example.englishnewsfix.app.domain.router.ScreenRouterImpl
import com.example.englishnewsfix.base.di.module.BaseModule
import com.example.englishnewsfix.base.di.scope.AppScope
import com.example.englishnewsfix.base.presentation.router.ScreenRouter
import dagger.Module
import dagger.Provides

@Module
class AppModule : BaseModule(){
    @Provides
    @AppScope
    fun provideScreenRouter(): ScreenRouter = ScreenRouterImpl()
}