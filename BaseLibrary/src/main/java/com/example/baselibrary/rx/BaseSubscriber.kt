package com.example.baselibrary.rx

import com.example.baselibrary.persenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(val baseView: BaseView): Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }
}