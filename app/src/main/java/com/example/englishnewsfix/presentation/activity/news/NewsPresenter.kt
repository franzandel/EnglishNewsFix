package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class NewsPresenter
@Inject constructor(private var mEnglishNewsRepository: EnglishNewsRepository
                    /*private var mTunaikuSession: TunaikuSession,
                    private var mProfileDataModel: ProfileDataModel,
                    private var mLaonDataModel: LoanDataModel,*/
//                    val mGson: Gson
                    ) : NewsContract.UserActionListener {

    lateinit var mView: NewsContract.View

    override fun setView(view: NewsContract.View) {
        mView = view
    }

    override fun fetchDataFromApi() {
        mView.showProgressBar()
        mView.getCompositeDisposable().add(
            mEnglishNewsRepository.getNewsRepo(mEnglishNewsRepository.requestAPIKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { news-> processNewsDataFromDB(news)})
                /*.subscribeWith(object : DisposableSubscriber<News>() {
                    override fun onNext(profile: News) {
                        mTunaikuSession.saveKtp(profile.pin!!)
                        fetchLoanAndProfileAPI(xAuth, profile.pin!!)
                        mView.hideProgressBar()
                    }

                    override fun onError(t: Throwable) {
                        mView.hideProgressBar()
                    }

                    override fun onComplete() {

                    }
                }*/
    }

    /*override fun processData() {
        processLoanDataFromDB(mLaonDataModel.selectAllDataDesc())
    }*/

    override fun processNewsDataFromDB(news: News) {
//        if (news.isNotEmpty()) {
//            mView.setAdapter(news)
//        }
        mView.setAdapter(news)

        mView.hideProgressBar()
    }
}