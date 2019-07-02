package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.data.repository.EnglishNewsRepository
import com.example.englishnewsfix.presentation.adapter.NewsRow
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsPresenter
@Inject constructor(private var mEnglishNewsRepository: EnglishNewsRepository
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
    }

    override fun processNewsDataFromDB(news: News) {
        mView.setAdapterParameter(news)
        mView.hideProgressBar()
    }

    override fun setAdapterValue(news: News, newsAdapter: GroupAdapter<ViewHolder>) {
        val articlesCopy = news.articles.map {article ->
            NewsRow(article)
        }

        val distinctArticles = articlesCopy.distinctBy {newsRow ->
            newsRow.article.source?.name
        }

        newsAdapter.addAll(distinctArticles)
        mView.setAdapter(news, newsAdapter)
    }
}