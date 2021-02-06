package com.dorukaneskiceri.arabamcomassignment.service

import com.dorukaneskiceri.arabamcomassignment.model.CarsModel
import io.reactivex.Single
import retrofit2.http.GET

interface CarsListAPI {

    @GET("api/v1/listing")
    fun getCarsList(): Single<List<CarsModel>>
}