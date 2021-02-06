package com.dorukaneskiceri.arabamcomassignment.model

import com.google.gson.annotations.SerializedName

data class CarsLocationModel(
    @SerializedName("cityName")
    val cityName: String,
    @SerializedName("townName")
    val townName: String
)