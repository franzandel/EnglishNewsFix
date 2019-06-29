package com.example.englishnewsfix.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.englishnewsfix.presentation.common.navigationcontroller.ActivityNavigation
import com.google.gson.Gson
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Abstract class for handling all activities
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    /*@Inject
    lateinit var mTunaikuSession: TunaikuSession*/

    @Inject
    lateinit var mActivityNavigation: ActivityNavigation

    @Inject
    lateinit var mGson: Gson

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

    override fun onResume() {
        super.onResume()
        handlingConnectionState()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposables.clear()
    }

    /**
     * Handling Internet State on change in device
     * */

    private fun handlingConnectionState() {
        /*mDisposables.add(
                mRxBus.toObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { result ->
                            Log.d(javaClass.name, result.toString())
                        })*/
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }



    /*override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }*/

}