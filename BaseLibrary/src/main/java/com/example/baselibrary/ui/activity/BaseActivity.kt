package com.example.baselibrary.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baselibrary.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

open class BaseActivity: RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}