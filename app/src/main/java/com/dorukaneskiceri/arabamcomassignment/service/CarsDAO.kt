package com.dorukaneskiceri.arabamcomassignment.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CarsDAO {

    @Insert
    suspend fun insertAllAdvertisements(vararg adverts: CarsModel): List<Long>

    @Query("SELECT * FROM CarsModel")
    suspend fun getAllAdvertisements(): List<CarsModel>

    @Query("SELECT * FROM CarsModel WHERE advertisementUuid = :advertisementId")
    suspend fun getAdvertisementById(advertisementId: Long): CarsModel

    @Query("DELETE FROM CarsModel")
    suspend fun deleteAdvertisements()
}