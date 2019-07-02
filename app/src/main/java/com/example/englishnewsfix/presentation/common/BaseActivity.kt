package com.example.englishnewsfix.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Abstract class for handling all activities
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    @Inject
    lateinit var mActivityNavigation: ActivityNavigation

    var mDisposables = CompositeDisposable()

    private var presenter: BasePresenter<*>? = null

    /**
     * This function replace onCreate as main function run in activity
     * Auto Dependency Injection
     * @param savedInstanceState
     * */

    abstract fun onActivityReady(savedInstanceState: Bundle?)

    /**
     * Getting Layout ID from activity
     * */

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        //Auto DI
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        onActivityReady(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposables.clear()
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }
}