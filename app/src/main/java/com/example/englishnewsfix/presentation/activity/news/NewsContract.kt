package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.common.BaseView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.disposables.CompositeDisposable

class NewsContract {
    interface View : BaseView {
        fun showProgressBar()
        fun hideProgressBar()
        fun showError(msg: String)
        fun setAdapterParameter(news: News)
        fun setAdapter(news: News, newsAdapter: GroupAdapter<ViewHolder>)
        fun getCompositeDisposable(): CompositeDisposable
    }

    interface UserActionListener{
        fun setView(view: View)
        fun fetchDataFromApi()
        fun processNewsDataFromDB(news: News)
        fun setAdapterValue(news: News, newsAdapter: GroupAdapter<ViewHolder>)
    }
}