package com.example.englishnewsfix.di.component

import android.app.Application
import com.example.englishnewsfix.di.module.NetworkModule
import com.example.englishnewsfix.EnglishNewsApp
import com.example.englishnewsfix.di.module.AppModule
import com.example.englishnewsfix.di.module.builder.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityBuilder::class),
    (NetworkModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: EnglishNewsApp)
}