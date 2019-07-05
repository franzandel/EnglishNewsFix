package com.example.englishnewsfix.base.presentation.presenter

import com.example.englishnewsfix.base.presentation.view.BaseView

interface IBasePresenter<in V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}