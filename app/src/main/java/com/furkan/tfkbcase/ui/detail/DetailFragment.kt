package com.furkan.tfkbcase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.furkan.tfkbcase.base.BaseFragment
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.DetailFragmentBinding
import com.furkan.tfkbcase.utils.WrapperTypeModel
import com.furkan.tfkbcase.utils.extension.loadImage
import com.furkan.tfkbcase.utils.formatDate

class DetailFragment : BaseFragment<DetailFragmentBinding>() {

  //  var data: Result? = null
    private val args : DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        configureTopMenu()
        configurePage()
    }

    private fun configurePage() {
        binding?.tvName?.text = args.detailData.artistName
        args.detailData.artworkUrl100?.let { binding?.ivHeader?.loadImage(it) }
        if (args.detailData.wrapperType == WrapperTypeModel.AUDIO_BOOK.code) {
            binding?.tvSongName?.text =  args.detailData.primaryGenreName
        } else {
            binding?.tvSongName?.text = args.detailData.trackName
        }
        binding?.tvCollection?.text = args.detailData.collectionName
        binding?.tvCountry?.text = args.detailData.country
        binding?.tvCurrency?.text = args.detailData.currency
        binding?.tvReleaseDate?.text = args.detailData.releaseDate?.let { formatDate(it) }
    }

    private fun configureTopMenu() {

        args.detailData.artistName?.let { binding?.contentTop?.setText(it) }
        binding?.contentTop?.binding?.ivBack?.setOnClickListener {

            val navController = findNavController()
            navController.popBackStack()

        }
    }

    private fun getData() {
//        data = arguments?.get("data") as Result
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DetailFragmentBinding {
        return DetailFragmentBinding.inflate(inflater, container, false)
    }

}