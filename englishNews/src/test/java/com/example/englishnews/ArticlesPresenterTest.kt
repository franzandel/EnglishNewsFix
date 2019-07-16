package com.example.englishnews

import com.example.englishnews.util.TestSchedulerProvider
import com.example.englishnews.articles.presentation.activity.presenter.ArticlesPresenter
import com.example.feature.news.data.response.Article
import com.example.feature.news.data.response.News
import com.example.feature.news.data.response.Source
import com.nhaarman.mockito_kotlin.mock
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * Created by Franz Andel on 2019-07-16.
 * Android Engineer
 */

class ArticlesPresenterTest {

    private lateinit var mPresenter: ArticlesPresenter
    private lateinit var mTestScheduler: TestScheduler

    private var articlesAdapter: GroupAdapter<ViewHolder> = mock()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)

        mPresenter = ArticlesPresenter(
            testSchedulerProvider
        )
    }

    private fun getFakeNews() : News {
        val articleList = ArrayList<Article>()
        val source = Source("jira", "JIRA")
        val article = Article("Grindael", "This is amazing content of Grindael's writing",
            "", "New York, Aug 8 2019", source, "Amazing Power", "www.grindael.com",
            "www.grindael.com/images/1")

        articleList.add(article)

        return News(articleList, "ok", 42)
    }

    private fun getFakeSourceName() = "Hahaha.com"


    @Test
    fun isSetAdapterValueValid() {
        mPresenter.apply {
            news = getFakeNews()
            sourceName = getFakeSourceName()
            setAdapterValue(articlesAdapter)
        }
    }

    @Test
    fun isSearchDataValid() {
        mPresenter.apply {
            news = getFakeNews()
            sourceName = getFakeSourceName()
            searchData("test Search", articlesAdapter)
        }
    }

    @Test
    fun isSearchDataEmptyValid() {
        mPresenter.apply {
            news = getFakeNews()
            sourceName = getFakeSourceName()
            searchData("", articlesAdapter)
        }
    }

    @Test
    fun isSearchDataNullValid() {
        mPresenter.apply {
            news = getFakeNews()
            sourceName = getFakeSourceName()
            searchData("null", articlesAdapter)
        }
    }

    @Test
    fun isResetAdapterValid() {
        mPresenter.apply {
            news = getFakeNews()
            sourceName = getFakeSourceName()
            resetAdapter(articlesAdapter)
        }
    }

    @Test
    fun isSetIntentParameters() {
        val news = getFakeNews()
        val sourceName = getFakeSourceName()

        mPresenter.setIntentParameters(news, sourceName)
    }
}