package com.mahipal.feature_one.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ShowTime(
    @SerializedName("showTime")
    @Expose
    val showTime:String,
    @SerializedName("showDateCode")
    @Expose
    val showDateCode: Long
): Serializable
