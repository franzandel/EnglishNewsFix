package com.example.englishnewsfix.di.module

import android.content.Context
import com.example.englishnewsfix.BuildConfig
import com.example.englishnewsfix.data.network.NewsNetworkService
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/*const val url = "https://newsapi.org/v2/top-headlines?country=us" +
                "&category=business" +
                "&apiKey=f79d6965f8814037b1412eb6451944ba"*/
const val baseUrl = "https://newsapi.org"

@Module
class NetworkModule(private val context: Context) {

    /*@Provides
    @Singleton
    @Named("GetNews")
    fun provideProvinceRestClient(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
            .baseUrl(url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
        return builder.build()
    }*/

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(ChuckInterceptor(context))
        }

        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)

        return okHttpClient.build()
    }

    @Provides
    @Singleton
    @Named("news_rest")
    fun provideRestClient(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        builder.client(okHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideNewsNetworkService(@Named("news_rest") restAdapter: Retrofit): NewsNetworkService {
        return restAdapter.create<NewsNetworkService>(NewsNetworkService::class.java)
    }
}