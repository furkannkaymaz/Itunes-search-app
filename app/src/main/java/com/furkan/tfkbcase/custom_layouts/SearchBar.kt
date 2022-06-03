package com.furkan.tfkbcase.custom_layouts

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.furkan.tfkbcase.base.BaseLinearLayout
import com.furkan.tfkbcase.databinding.CustomSearchBinding

class SearchBar(context: Context, attrs: AttributeSet? = null) :
    BaseLinearLayout<CustomSearchBinding>(context, attrs) {

    override fun createView(inflater: LayoutInflater): CustomSearchBinding {
        return CustomSearchBinding.inflate(inflater, this, true)
    }

    override fun viewCreated(attrs: AttributeSet?) {

        binding.ivClose.setOnClickListener {
            binding.editTextSearch.text = null

        }
    }

}