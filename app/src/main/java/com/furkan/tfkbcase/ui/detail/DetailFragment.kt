package com.furkan.tfkbcase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.furkan.tfkbcase.base.BaseFragment
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.DetailFragmentBinding
import com.furkan.tfkbcase.utils.formatDate
import com.furkan.tfkbcase.utils.extension.loadImage

class DetailFragment : BaseFragment<DetailFragmentBinding>() {

    var data: Result? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        configureTopMenu()
        configurePage()
    }

    private fun configurePage() {
        binding?.tvName?.text = data?.artistName
        data?.artworkUrl100?.let { binding?.ivHeader?.loadImage(it) }
        binding?.tvSongName?.text = data?.trackName
        binding?.tvCollection?.text = data?.collectionName
        binding?.tvCountry?.text = data?.country
        binding?.tvCurrency?.text = data?.currency
        binding?.tvReleaseDate?.text = data?.releaseDate?.let { formatDate(it) }
    }

    private fun configureTopMenu() {

        data?.artistName?.let { binding?.contentTop?.setText(it, requireActivity()) }
        binding?.contentTop?.binding?.ivBack?.setOnClickListener {

            val navController = findNavController()
            navController.popBackStack()

        }
    }

    private fun getData() {
        data = arguments?.get("data") as Result
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DetailFragmentBinding {
        return DetailFragmentBinding.inflate(inflater, container, false)
    }

}