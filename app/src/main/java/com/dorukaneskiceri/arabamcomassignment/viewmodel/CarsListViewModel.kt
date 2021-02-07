package com.dorukaneskiceri.arabamcomassignment.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dorukaneskiceri.arabamcomassignment.service.CarsModel
import com.dorukaneskiceri.arabamcomassignment.service.CarsListService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

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
                        //storeInRoom(t)
                        showCars(t)
                    }
                })
        )
    }

//    private fun storeInRoom(carsList: List<CarsModel>){
//        launch {
//            val dao = CarsDatabase(getApplication()).carsDao()
//            dao.deleteAdvertisements()
//            val longList = dao.insertAllAdvertisements(*carsList.toTypedArray())
//            var i = 0
//            while (i < longList.size){
//                carsList[i].advertisementUuid = longList[i]
//                i++
//            }
//        }
//        showCars(carsList)
//    }

    private fun showCars(carsList: List<CarsModel>) {
        loadingState.value = false
        this.carsList.value = carsList
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}