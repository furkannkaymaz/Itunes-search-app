package com.furkan.tfkbcase.custom_layouts

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.furkan.tfkbcase.base.BaseLinearLayout
import com.furkan.tfkbcase.databinding.CustomTopcontentBinding
import kotlinx.android.synthetic.main.custom_topcontent.view.*

class CustomAddTopContent(context: Context, attrs: AttributeSet? = null) :
    BaseLinearLayout<CustomTopcontentBinding>(context, attrs) {

    override fun createView(inflater: LayoutInflater): CustomTopcontentBinding {
        return CustomTopcontentBinding.inflate(inflater, this, true)
    }

    override fun viewCreated(attrs: AttributeSet?) {

    }

    fun setText(text: String){
        binding.tvTitleHeader.text = text
    }

    fun backButtonVisible(isVisible: Boolean){
        if (isVisible){
            ivBack.visibility = View.VISIBLE
        }else{
            ivBack.visibility = View.INVISIBLE
        }
    }
}