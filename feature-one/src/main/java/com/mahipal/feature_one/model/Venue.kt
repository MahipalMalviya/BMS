package com.mahipal.feature_one.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Venue(
    @SerializedName("name")
    @Expose
    val name:String,
    @SerializedName("showDate")
    @Expose
    val showDate:String,
    @SerializedName("showtimes")
    @Expose
    val showTimes:List<ShowTime>
): Serializable
