package com.dorukaneskiceri.arabamcomassignment.model

import com.google.gson.annotations.SerializedName

data class CarsCategory(
    @SerializedName("id")
    val categoryId: Int,
    @SerializedName("name")
    val categoryName: String
)
