package com.furkan.tfkbcase.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.furkan.tfkbcase.R
import com.furkan.tfkbcase.base.BaseFragment
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.DetailFragmentBinding
import com.furkan.tfkbcase.databinding.MainFragmentBinding

class DetailFragment : BaseFragment<DetailFragmentBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.get("data") as Result
        Log.d("deneme",data.artistName.toString())


    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DetailFragmentBinding {
        return DetailFragmentBinding.inflate(inflater, container, false)
    }

}