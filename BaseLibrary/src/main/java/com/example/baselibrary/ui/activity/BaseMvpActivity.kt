package com.example.baselibrary.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.example.baselibrary.persenter.BasePresenter
import com.example.baselibrary.persenter.view.BaseView
import com.example.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

open abstract class BaseMvpActivity <T: BasePresenter<*>>: BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent
    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        initActivityInjection()
        mLoadingDialog = ProgressLoading.create(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }
    override fun onError(text:String) {
        toast(text)
    }
}