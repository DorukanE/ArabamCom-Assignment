package com.dorukaneskiceri.arabamcomassignment.service

import com.dorukaneskiceri.arabamcomassignment.model.CarsModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsListAPI {

    @GET("api/v1/listing")
    fun getCarsList(
        @Query("take") take: Int,
        @Query("skip") skip: Int
    ): Single<List<CarsModel>>
}