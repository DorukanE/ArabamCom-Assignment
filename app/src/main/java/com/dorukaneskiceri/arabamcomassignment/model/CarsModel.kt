package com.dorukaneskiceri.arabamcomassignment.model

import com.google.gson.annotations.SerializedName


data class CarsModel(
    @SerializedName("id")
    val advertisementId: Long,
    @SerializedName("title")
    val advertisementTitle: String,
    @SerializedName("location")
    val advertisementLocation: CarsLocationModel,
    @SerializedName("category")
    val advertisementCategory: CarsCategory,
    @SerializedName("modelName")
    val advertisementModelName: String,
    @SerializedName("price")
    val advertisementPrice: Long,
    @SerializedName("priceFormatted")
    val advertisementPriceFormatted: String,
    @SerializedName("date")
    val advertisementDate: String,
    @SerializedName("dateFormatted")
    val advertisementDateFormatted: String,
    @SerializedName("photo")
    val advertisementPhoto: String,
    @SerializedName("properties")
    val advertisementProperties: List<CarsProperties>
)
