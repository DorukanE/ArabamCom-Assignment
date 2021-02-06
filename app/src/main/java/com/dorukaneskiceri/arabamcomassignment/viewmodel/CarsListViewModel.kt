package com.dorukaneskiceri.arabamcomassignment.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dorukaneskiceri.arabamcomassignment.model.CarsModel
import com.dorukaneskiceri.arabamcomassignment.service.CarsListService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CarsListViewModel(application: Application) : BaseViewModel(application) {

    val carsList = MutableLiveData<List<CarsModel>>()
    val loadingState = MutableLiveData<Boolean>()
    val errorState = MutableLiveData<Boolean>()
    private val disposable = CompositeDisposable()
    private val carsApiService = CarsListService()

    fun getCarsList(take: Int, skip: Int) {
        getDataFromAPI(take, skip)
    }

    private fun getDataFromAPI(take: Int, skip: Int) {
        loadingState.value = true
        disposable.add(
            carsApiService.getCarsFromAPI(take, skip)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CarsModel>>() {

                    override fun onError(e: Throwable) {
                        errorState.value = true
                        loadingState.value = false
                        println(e.localizedMessage)
                    }

                    override fun onSuccess(t: List<CarsModel>) {
                        println("Process started")
                        loadingState.value = false
                        carsList.value = t
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}