package com.example.englishnewsfix.presentation.activity.articles

import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.englishnewsfix.R
import com.example.englishnewsfix.data.entities.News
import com.example.englishnewsfix.presentation.activity.news.NewsActivity
import com.example.englishnewsfix.presentation.common.BaseActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_articles.*
import kotlinx.android.synthetic.main.activity_searchbar.*
import kotlinx.android.synthetic.main.activity_toolbar.tvToolbarTitle
import kotlinx.android.synthetic.main.activity_toolbar_back.*
import javax.inject.Inject

class ArticlesActivity : BaseActivity(), ArticlesContract.View {
    @Inject
    lateinit var mArticlesPresenter: ArticlesPresenter
    @Inject
    lateinit var articlesAdapter: GroupAdapter<ViewHolder>
    var mQuery = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_articles
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        setupUI()
        setupIntentParameters()
        mArticlesPresenter.setAdapterValue(articlesAdapter)
    }

    override fun setAdapter(articlesAdapter: GroupAdapter<ViewHolder>) {
        recyclerView_articles.adapter = articlesAdapter
    }

    /**
     * Setup UI in the first Time when this activity Load
     * */

    private fun setupUI() {
        setupToolbar()
        mArticlesPresenter.attachView(this)
        setupRecyclerView()
    }

    /**
     * Setup Toolbar for title, handling on back and SearchBar
     * */

    private fun setupToolbar() {
        //Setup
        tvToolbarTitle.text = resources.getString(R.string.articles_toolbar_title)
        btnToolbarBack.setOnClickListener {
            onBackPressed()
        }

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query != null && query.isNotEmpty()) {
                    mQuery = query.trim().toLowerCase()
                    mArticlesPresenter.searchData(query, articlesAdapter)
                } else {
                    mArticlesPresenter.resetAdapter(articlesAdapter)
                }
                return false
            }
        })

        btnSearchAddress.setOnClickListener {
            val query = searchBar.query.toString()

            if (query.isNotEmpty()) {
                mQuery = query.trim().toLowerCase()
                mArticlesPresenter.searchData(query, articlesAdapter)
            }
        }
    }

    private fun setupRecyclerView() {
        recyclerView_articles.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun setupIntentParameters() {
        val news = intent.getParcelableExtra<News>(NewsActivity.NEWS_KEY)
        val sourceName = intent.getStringExtra(NewsActivity.SOURCE_NAME_KEY)

        mArticlesPresenter.setIntentParameters(news, sourceName)
    }
}
