package com.example.baselibrary.ui.fragment

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.example.baselibrary.persenter.BasePresenter
import com.example.baselibrary.persenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import javax.inject.Inject

open abstract class BaseMvpFragment <T: BasePresenter<*>>: BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        initActivityInjection()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
    }
    override fun hideLoading() {
    }

    override fun onError(text:String) {
        toast(text)
    }

}