package com.example.englishnewsfix

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.englishnewsfix.di.component.AppComponent
import com.example.englishnewsfix.di.component.DaggerAppComponent
import com.example.englishnewsfix.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class EnglishNewsApp : Application(), HasActivityInjector {
    companion object {
        @JvmStatic
        lateinit var instance: EnglishNewsApp
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        //Set Instance
        instance = this
        //Create App Component
        appComponent = createComponent()
        appComponent.inject(this)
    }

    /**
     * Initialize Dependency Injection With Dagger
     * Level DI Application
     * */


    private fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .networkModule(NetworkModule(applicationContext))
                .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}