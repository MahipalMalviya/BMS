package com.mahipal.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahipal.assignment.databinding.LayoutMovieListBinding
import com.mahipal.feature_one.model.Venue
import com.mahipal.core.ImageLoader
import javax.inject.Inject

class ShowTimesAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<ShowTimesAdapter.MyViewHolder>() {

    private var list: List<Venue> = mutableListOf()
    var onShowTimeClick: ((Venue) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(itemList: List<Venue>?) {
        if (itemList != null) {
            list = itemList
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(private val binding: LayoutMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(venue: Venue) {
            binding.tvTheatreName.text = venue.name
            binding.tvMovieDate.text = venue.showDate

            imageLoader.loadImage(
                imageUrl = "https://static.businessworld.in/article/article_extra_large_image/1609147522_O1aw88_BMS.jpg",
                imageView = requireNotNull(binding.ivMovie)
            )

            binding.btnShowDates.setOnClickListener {
                onShowTimeClick?.invoke(venue)
            }
        }

    }
}