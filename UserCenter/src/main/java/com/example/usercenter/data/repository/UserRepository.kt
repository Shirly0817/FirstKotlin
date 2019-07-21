package com.example.usercenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * 直接访问数据的类
 */
class UserRepository @Inject constructor(){
    fun register(mobile: String, pwd: String, verifyCode: String)
    : Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, pwd, verifyCode))
        //通过RetrofitFactory中的单例模式创建一个service，然后调取注册方法
    }
}