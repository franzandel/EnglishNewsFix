package com.example.englishnewsfix.data.repository

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.data.network.NewsNetworkService
import com.google.gson.Gson
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class EnglishNewsRepository
@Inject constructor(/*private var newsNetworkService: NewsNetworkService*/
                    /*var mLoanDataModel: LoanDataModel,
                    var mProfileDataModel: ProfileDataModel,
                    var mTunaikuSession: TunaikuSession,
                    var mHelper: Helper,
                    var mGson: Gson,
                    val scheduler: SchedulerProvider*/) {

    private var mAddress: String? = null

    /**
     * Get News Data
     * @Param mXauth
     */
    /*fun getNewsRepo(mXauth: String): Flowable<List<News>> {
        return newsNetworkService.getAllNews(mXauth)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }*/

    fun requestAPIKey(): String {
//        return NewsNetworkService.API_KEY
        return "f79d6965f8814037b1412eb6451944ba"
    }
}
