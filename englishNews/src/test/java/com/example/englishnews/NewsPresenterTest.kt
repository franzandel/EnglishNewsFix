package com.example.englishnews

import com.example.feature.news.data.response.Article
import com.example.feature.news.data.response.News
import com.example.feature.news.data.response.Source
import com.example.feature.news.domain.usecase.NewsUseCase
import com.example.feature.news.presentation.activity.contract.NewsContract
import com.example.feature.news.presentation.activity.presenter.NewsPresenter
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.example.englishnews.util.TestSchedulerProvider
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.Flowable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * Created by Franz Andel on 2019-07-15.
 * Android Engineer
 */
class NewsPresenterTest {

    private lateinit var mPresenter: NewsPresenter
    private lateinit var mTestScheduler: TestScheduler

    private var mUseCase: NewsUseCase = mock()
    private var mView: NewsContract.View = mock()

    private var newsAdapter: GroupAdapter<ViewHolder> = mock()

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)

        mPresenter = NewsPresenter(
            mUseCase,
            testSchedulerProvider
        )

        mPresenter.attachView(mView)
    }

    @Test
    fun isSetAdapterValid() {
        val articleList = ArrayList<Article>()
        val source = Source("jira", "JIRA")
        val article = Article("Grindael", "This is amazing content of Grindael's writing",
            "", "New York, Aug 8 2019", source, "Amazing Power", "www.grindael.com",
            "www.grindael.com/images/1")

        articleList.add(article)

        val news = News(articleList, "ok", 42)

        mPresenter.setAdapterValue(news, newsAdapter)
    }

    @Test
    fun isFetchDataFromApiValid() {
        val articleList = ArrayList<Article>()
        val source = Source("jira", "JIRA")
        val article = Article("Grindael", "This is amazing content of Grindael's writing",
            "", "New York, Aug 8 2019", source, "Amazing Power", "www.grindael.com",
            "www.grindael.com/images/1")

        articleList.add(article)

        val news = News(articleList, "ok", 42)

        val API_KEY = "f79d6965f8814037b1412eb6451944ba"

        doReturn(Flowable.just(news))
            .`when`(mUseCase)
            .getNewsRepo(API_KEY)

        mPresenter.fetchDataFromApi()

        mTestScheduler.triggerActions()
    }

    @Test
    fun isOnSuccessFetchDataValid() {
        val articleList = ArrayList<Article>()
        val source = Source("jira", "JIRA")
        val article = Article("Grindael", "This is amazing content of Grindael's writing",
            "", "New York, Aug 8 2019", source, "Amazing Power", "www.grindael.com",
            "www.grindael.com/images/1")

        articleList.add(article)

        val news = News(articleList, "ok", 42)

        mPresenter.onSuccessFetchData(news)
    }
}