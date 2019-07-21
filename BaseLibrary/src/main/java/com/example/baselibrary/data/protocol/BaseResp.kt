package com.example.baselibrary.data.protocol

/**
 * 基础响应接收类
 */
class BaseResp<out T> (val status: Int, val message: String, val data: T)