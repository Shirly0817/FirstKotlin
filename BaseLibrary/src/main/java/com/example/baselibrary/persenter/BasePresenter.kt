package com.example.baselibrary.persenter

import android.content.Context
import com.example.baselibrary.persenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T: BaseView> {
    lateinit var mView: T
    lateinit var lifecycleProvider: LifecycleProvider<*>
    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}