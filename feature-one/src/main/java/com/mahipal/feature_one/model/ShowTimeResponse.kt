package com.mahipal.feature_one.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ShowTimeResponse(
    @SerializedName("venues")
    @Expose
    val venues: List<Venue>
)
