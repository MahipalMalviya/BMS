package com.mahipal.feature_one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mahipal.core.ImageLoader
import com.mahipal.feature_one.adapter.TimesAdapter
import com.mahipal.feature_one.databinding.ActivityFeatureOneBinding
import com.mahipal.feature_one.di.FeatureOneDaggerProvider
import com.mahipal.feature_one.model.Venue
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureOneBinding

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var timesAdapter: TimesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FeatureOneDaggerProvider.component.inject(this)


        initialize()
    }

    private fun initialize() {
        binding.rvTimes.layoutManager = GridLayoutManager(this,3)
        binding.rvTimes.adapter = timesAdapter

        val venue = intent.getSerializableExtra("times") as Venue?
        setDataToView(venue)

    }

    private fun setDataToView(venue: Venue?) {
        venue?.let {
            binding.tvTheatreName.text = it.name
            binding.tvMovieDate.text = it.showDate

            timesAdapter.setData(it.showTimes)

            imageLoader.loadImage(
                imageUrl = "https://static.businessworld.in/article/article_extra_large_image/1609147522_O1aw88_BMS.jpg",
                imageView = requireNotNull(binding.ivMovie)
            )
        }
    }
}