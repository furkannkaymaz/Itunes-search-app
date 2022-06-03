package com.furkan.tfkbcase.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkan.tfkbcase.base.BaseAdapter
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.ItemSongBinding
import com.furkan.tfkbcase.utils.WrapperTypeModel
import com.furkan.tfkbcase.utils.extension.loadImage

class MainAdapter(private val itemClick: ((Result) -> Unit)?) : BaseAdapter<Result, MainAdapter.ViewHolder>() {

    override fun bindView(holder: ViewHolder, position: Int, item: Result) {

        when (item.wrapperType) {
            WrapperTypeModel.AUDIO_BOOK.code -> {
                holder.binding.title.text = item.artistName
            }
            WrapperTypeModel.TRACK.code -> {
                holder.binding.title.text = item.trackName
            }
        }
        item.artworkUrl100?.let { holder.binding.image.loadImage(it) }

        holder.binding.container.setOnClickListener {

            itemClick?.let { it1 -> it1(item) }

        }

    }

    override fun createView(
        context: Context,
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemSongBinding.inflate(inflater, parent, false))
    }

    class ViewHolder(val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root)

}