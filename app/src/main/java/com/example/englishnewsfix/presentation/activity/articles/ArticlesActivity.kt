package com.example.englishnewsfix.presentation.activity.articles

import android.os.Bundle
import com.example.englishnewsfix.R
import com.example.englishnewsfix.presentation.common.BaseActivity
import kotlinx.android.synthetic.main.activity_toolbar.*
import javax.inject.Inject

class ArticlesActivity : BaseActivity(), ArticlesContract.View {

    /*@Inject
    lateinit var mNewsPresenter: NewsPresenter*/

    override fun getLayoutId(): Int {
        return R.layout.activity_articles
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        setupUI()
    }

    /**
     * Setup UI in the first Time when this activity Load
     * */

    fun setupUI() {
        setupToolbar()
        /*etLoginPhoneNumber.requestFocus()
        //Setup Chat Us
        tvLoginChatUs.setOnClickListener {
            openChat()
        }

        btnLoginChatUs.setOnClickListener {
            openChat()
        }

        //Handling Phone number on change state
        etLoginPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val mInput = s!!.toString()
                if (mInput.isNotEmpty()) {
                    mAnalytics.sendEventAnalytics("inp_phone_login_change")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                etLoginPhoneNumber.error = null
                etLoginKtp.error = null
                layoutPhone.background = ContextCompat.getDrawable(applicationContext, R.drawable.cs_view_edittext_gray)
            }

        })

        //Handling ktp on change state
        etLoginKtp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val mInput = s!!.toString()
                if (mInput.isNotEmpty()) {
                    mAnalytics.sendEventAnalytics("inp_noktp_login_change")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                etLoginKtp.error = null
                etLoginPhoneNumber.error = null
                linearlayout_no_ktp.background = ContextCompat.getDrawable(applicationContext, R.drawable.cs_view_edittext_gray)
            }

        })
        btnLogin.setOnClickListener {
            mHelper.hideSoftKeyboard(this)
            mNoHp = etLoginPhoneNumber.text.toString()
            mKtp = etLoginKtp.text.toString()
            if (mHelper.isNetworkConnected(applicationContext)) {
                mAnalytics.sendEventAnalytics("btn_login_reqotp_click")
                if (linearlayout_no_ktp.visibility == View.GONE) {
                    mLoginPresenter.checkingData(null, etLoginPhoneNumber.text.toString())
                } else {
                    mLoginPresenter.checkingData(etLoginKtp.text.toString(), etLoginPhoneNumber.text.toString())
                }
            } else {
                showSnackBar("Tidak dapat Login, pastikan internet kamu lancar")
            }
        }

        //Setup Fb Page
        btnLoginFb.setOnClickListener {
            mActivityNavigation.openFacebookApp()
        }

        //Setup Twitter Page
        btnLoginTwitter.setOnClickListener {
            mActivityNavigation.openTwitterApp()
        }*/
    }

    /**
     * Setup Toolbar for title and handling on back
     * */

    fun setupToolbar() {
        //Setup
        tvToolbarTitle.text = resources.getString(R.string.news_toolbar_title)
    }
}
