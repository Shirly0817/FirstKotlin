package com.example.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.baselibrary.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null

    init{
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = typeArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typeArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typeArray.getString(R.styleable.HeaderBar_rightText)
        initView()
        typeArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if(isShowBack) View.VISIBLE else View.GONE
        titleText?.let { //如果titleText 不为空，则执行该方法，并把titleText作为参传进去
            mTitleTv.text = it  //it就代表传进来的参数titleText
        }
        rightText?.let { //如果titleText 不为空，则执行该方法，并把titleText作为参传进去
            mRightTv.text = it  //it就代表传进来的参数titleText
        }
    }
}