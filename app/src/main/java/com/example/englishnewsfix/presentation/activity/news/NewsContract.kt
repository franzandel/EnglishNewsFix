package com.example.englishnewsfix.presentation.activity.news

import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.adapter.NewsRow
import com.example.englishnewsfix.presentation.common.BaseView
import io.reactivex.disposables.CompositeDisposable

class NewsContract {
    interface View : BaseView {
        fun showProgressBar()
        fun hideProgressBar()
        fun showError(msg: String)
        fun setAdapter(news: News)
        fun getCompositeDisposable(): CompositeDisposable
        /*fun onBack()
        fun showKtpLayout()
        fun hideKtpLayout()
        fun showLoginHelp()
        fun showErrorPhoneNumber(errType : Int)
        fun showErrorPhoneNumber(errMsg: String?)
        fun showErrorKtpNumber(errMsg: String?)
        fun showErrorKtpNumber(errType: Int?)
        fun hideWordingLoginKtp()
        fun showWordingLoginKtp(msg:String)
        fun showSnackBar(msg :String)
        fun errorInputField(layout:String, show:Boolean)
        fun showLoading()
        fun hideLoading()
        fun openChat()
        fun hideSoftKeyboard()*/
    }

    interface UserActionListener{
        fun setView(view: View)
        fun fetchDataFromApi()
        fun processNewsDataFromDB(news: News)
        /*fun submitLogin(noKtp: String?, noHp: String)
        fun isPhoneNumberValid(phoneNumber: String): Boolean?
        fun isKtpValid(noKtp: String): Boolean?
        fun handlingHttpErrorCode(err: Throwable)
        fun checkingData(noKtp: String?, noHp: String?)
        fun deleteAllRegistrationSectionData()*/
    }
}