package com.furkan.tfkbcase.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkan.tfkbcase.data.model.Result
import com.furkan.tfkbcase.databinding.ItemSongBinding
import com.furkan.tfkbcase.utils.loadImage

class MainAdapter(var data: ArrayList<Result?>?) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val itemBinding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val paymentBean: Result = data?.get(position)!!
        holder.bind(paymentBean)
    }

    fun updateData(item: ArrayList<Result?>?) {
        data?.addAll(item!!)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data!!.size

    class MainHolder(private val itemBinding: ItemSongBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(paymentBean: Result) {
            itemBinding.title.text = paymentBean.trackName
            paymentBean.artworkUrl100?.let { itemBinding.image.loadImage(it) }
        }
    }
}