package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import com.example.englishnewsfix.external.SchedulerProvider
import com.example.englishnewsfix.presentation.adapter.NewsRow
import com.example.englishnewsfix.presentation.common.BasePresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsPresenter
@Inject constructor(private var mEnglishNewsRepository: EnglishNewsRepository,
                    schedulerProvider: SchedulerProvider
                    ) : BasePresenter<NewsContract.View>(schedulerProvider),
                        NewsContract.UserActionListener {

    override fun fetchDataFromApi() {
        view?.showProgressBar()
        addDisposable(mEnglishNewsRepository.getNewsRepo(mEnglishNewsRepository.requestAPIKey())
            .subscribeOn(scheduler.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ news ->
                onSuccessFetchData(news)
            }, { err ->
                onFailedFetchData(err.message)
            }))
    }

    override fun onSuccessFetchData(news: News) {
        view?.setAdapterParameter(news)
        view?.hideProgressBar()
    }

    override fun onFailedFetchData(errMsg: String?) {
        view?.showError(errMsg!!)
        view?.hideProgressBar()
    }

    override fun setAdapterValue(news: News, newsAdapter: GroupAdapter<ViewHolder>) {
        val articlesCopy = news.articles.map {article ->
            NewsRow(article)
        }

        val distinctArticles = articlesCopy.distinctBy {newsRow ->
            newsRow.article.source?.name
        }

        newsAdapter.addAll(distinctArticles)
        view?.setAdapter(news, newsAdapter)
    }
}