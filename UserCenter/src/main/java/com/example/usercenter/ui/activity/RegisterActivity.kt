package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.AppManager
import com.example.baselibrary.ext.onClick
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.persenter.RegisterPresenter
import com.example.usercenter.persenter.view.RegisterView
import com.kotlin.base.widgets.VerifyButton
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    private var pressTime: Long = 0

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterBtn.onClick {
            mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
        }
        mGetVerifyCodeBtn.onClick {
            mGetVerifyCodeBtn.requestSendVerifyNumber()
        }
    }

    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        if(currentTime - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = currentTime
        }else{
            AppManager.instance.exitApp(this)
        }
    }

}
