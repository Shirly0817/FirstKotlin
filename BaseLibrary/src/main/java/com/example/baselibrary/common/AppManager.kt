package com.example.baselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Activity管理栈
 */
class AppManager private constructor(){
    private val activityStack: Stack<Activity> = Stack()

    companion object{
        val instance: AppManager by lazy { AppManager() }
    }

    /*
        入栈
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /*
        出栈
     */
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /*
        获取当前栈顶的Activity
     */
    fun currentActivity(): Activity{
        return activityStack.lastElement()
    }

    /*
        清理栈
     */
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

    /*
        退出应用程序
     */
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}