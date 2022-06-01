package com.furkan.tfkbcase.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkan.tfkbcase.utils.CallbackObject

abstract class BaseAdapter<Object, ViewHolder : RecyclerView.ViewHolder> : RecyclerView.Adapter<ViewHolder>() {

    var items: List<Object>? = null
    var recyclerView: RecyclerView? = null
    var callbackDidSelectItem: CallbackObject<Object>? = null

    open fun configureItemSize(holder: ViewHolder, position: Int, item: Object) {}
    abstract fun bindView(holder: ViewHolder, position: Int, item: Object)
    abstract fun createView(context: Context, parent: ViewGroup, inflater: LayoutInflater, viewType: Int): ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return createView(parent.context, parent, LayoutInflater.from(parent.context), viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.getOrNull(position)?.let {
            configureItemSize(holder, position, it)
            bindView(holder, position, it)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun getItemCount(): Int {
        return this.items?.size ?: 0
    }

    fun set(items: List<Object>?) {
        this.items = items
        this.notifyDataSetChanged()
    }

    fun clear() {
        this.items = emptyList()
        this.notifyDataSetChanged()
    }

    fun isLastItem(position: Int): Boolean {
        return (items?.size ?: 0) - 1 == position
    }

    fun isFirstItem(position: Int): Boolean {
        return 0 == position
    }

}