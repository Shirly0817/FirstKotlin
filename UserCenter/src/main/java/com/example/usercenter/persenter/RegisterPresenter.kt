package com.example.usercenter.persenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.persenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.persenter.view.RegisterView
import com.example.usercenter.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>(){
    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String){
        /**
         * 业务逻辑
         */
        if(!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.register(mobile, verifyCode, pwd)
                .execute(object :BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if(t) {
                            mView.onRegisterResult("注册成功")
                        }
                    }
                }, lifecycleProvider)
    }
}