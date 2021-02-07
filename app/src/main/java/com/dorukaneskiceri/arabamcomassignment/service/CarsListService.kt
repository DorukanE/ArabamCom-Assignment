package com.dorukaneskiceri.arabamcomassignment.service

import com.dorukaneskiceri.arabamcomassignment.util.Util
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CarsListService {

    private val api = Retrofit.Builder()
        .baseUrl(Util().BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CarsListAPI::class.java)

    fun getCarsFromAPI(take: Int, skip: Int): Single<List<CarsModel>>{
        return api.getCarsList(take, skip)
    }
}