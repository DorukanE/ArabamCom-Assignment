package com.dorukaneskiceri.arabamcomassignment.service

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity
data class CarsModel(
    @SerializedName(value = "id")
    val advertisementId: Long?,

    @SerializedName(value = "title")
    val advertisementTitle: String?,

    @SerializedName(value = "location")
    val advertisementLocation: CarsLocationModel?,

    @SerializedName(value = "category")
    val advertisementCategory: CarsCategory?,

    @SerializedName(value = "modelName")
    val advertisementModelName: String?,

    @SerializedName(value = "price")
    val advertisementPrice: Long?,

    @SerializedName(value = "priceFormatted")
    val advertisementPriceFormatted: String?,

    @SerializedName(value = "date")
    val advertisementDate: String?,

    @SerializedName(value = "dateFormatted")
    val advertisementDateFormatted: String?,

    @SerializedName(value = "photo")
    val advertisementPhoto: String?,

    @SerializedName(value = "properties")
    val advertisementProperties: List<CarsProperties>?,

) {
    @PrimaryKey(autoGenerate = true)
    var advertisementUuid: Long = 0

    data class CarsCategory(
        @SerializedName("id")
        val categoryId: Int?,
        @SerializedName("name")
        val categoryName: String?
    )

    data class CarsLocationModel(
        @SerializedName("cityName")
        val cityName: String?,
        @SerializedName("townName")
        val townName: String?
    )

    data class CarsProperties(
        @SerializedName("name")
        val propertyName: String?,
        @SerializedName("value")
        val propertyValue: String?
    )
}
