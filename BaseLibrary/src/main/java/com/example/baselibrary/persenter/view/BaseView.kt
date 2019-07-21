package com.example.baselibrary.persenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text: String)
}