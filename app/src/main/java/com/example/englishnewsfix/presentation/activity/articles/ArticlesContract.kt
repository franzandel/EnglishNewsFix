package com.example.englishnewsfix.presentation.activity.articles

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.common.BaseView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class ArticlesContract {
    interface View : BaseView {
        fun setAdapter(articlesAdapter: GroupAdapter<ViewHolder>)
    }

    interface UserActionListener{
        fun setView(view: View)
        fun setIntentParameters(news: News, sourceName: String)
        fun setAdapterValue(articlesAdapter: GroupAdapter<ViewHolder>)
        fun resetAdapter(articlesAdapter: GroupAdapter<ViewHolder>)
        fun searchData(query: String, articlesAdapter: GroupAdapter<ViewHolder>)
    }
}