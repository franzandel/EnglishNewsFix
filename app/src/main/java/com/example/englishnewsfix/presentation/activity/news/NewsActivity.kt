package com.example.englishnewsfix.presentation.activity.news

import android.os.Bundle
import android.view.View
import com.example.englishnewsfix.R
import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.adapter.NewsRow
import com.example.englishnewsfix.presentation.common.BaseActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_toolbar.*
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsContract.View {
    companion object {
        const val NEWS_KEY = "NEWS"
        const val SOURCE_NAME_KEY = "SOURCE_NAME"
    }

    @Inject
    lateinit var mNewsPresenter: NewsPresenter
    private val newsAdapter = GroupAdapter<ViewHolder>()

    override fun showProgressBar() {
        avNewsLoadingIndicator?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        avNewsLoadingIndicator?.visibility = View.GONE
    }

    override fun showError(msg: String) {

    }

    override fun setAdapter(newsList: List<News>) {
        val articlesCopy = newsList[0].articles.map {article ->
            NewsRow(article)
        }

        val distinctArticles = articlesCopy.distinctBy {newsRow ->
            newsRow.articles.source?.name
        }

        newsAdapter.addAll(distinctArticles)
        recyclerView_news.adapter = newsAdapter

        newsAdapter.setOnItemClickListener { item, _->
            val newsRow = item as NewsRow
            mActivityNavigation.navigateToArticlesPage(newsRow.articles.source?.name, newsList[0])
        }
    }

    override fun getCompositeDisposable(): CompositeDisposable {
        return mDisposables
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_news
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        setupUI()
    }

    /**
     * Setup UI in the first Time when this activity Load
     * */

    fun setupUI() {
        setupToolbar()
        mNewsPresenter.fetchDataFromApi()
    }

    /**
     * Setup Toolbar for title and handling on back
     * */

    fun setupToolbar() {
        //Setup
        tvToolbarTitle.text = resources.getString(R.string.news_toolbar_title)
    }
}
