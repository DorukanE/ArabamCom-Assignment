package com.dorukaneskiceri.arabamcomassignment.model

import com.google.gson.annotations.SerializedName

data class CarsProperties(
    @SerializedName("name")
    val propertyName: String,
    @SerializedName("value")
    val propertyValue: String
)
