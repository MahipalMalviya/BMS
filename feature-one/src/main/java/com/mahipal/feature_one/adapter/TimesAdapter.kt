package com.mahipal.feature_one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahipal.feature_one.databinding.LayoutTimeListBinding
import com.mahipal.feature_one.model.ShowTime
import javax.inject.Inject

class TimesAdapter @Inject constructor() :
    RecyclerView.Adapter<TimesAdapter.MyViewHolder>() {

    private var list: List<ShowTime> = mutableListOf()
    var onTimeClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutTimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(itemList: List<ShowTime>?) {
        if (itemList != null) {
            list = itemList
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(private val binding: LayoutTimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(time: ShowTime) {
            binding.tvTime.text = time.showTime
            binding.tvTime.setOnClickListener {
                onTimeClick?.invoke(time.showTime)
            }
        }

    }
}