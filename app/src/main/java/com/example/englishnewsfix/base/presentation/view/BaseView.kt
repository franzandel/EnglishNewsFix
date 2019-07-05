package com.example.englishnewsfix.base.presentation.view

import com.example.englishnewsfix.base.presentation.presenter.BasePresenter

interface BaseView{
    fun setPresenter(presenter: BasePresenter<*>)
}