//package com.dorukaneskiceri.arabamcomassignment.service
//
//import android.content.Context
//import androidx.room.*
//
//@Database(entities = [CarsModel::class], version = 1)
//abstract class CarsDatabase: RoomDatabase()  {
//
//    abstract fun carsDao(): CarsDAO
//
//    //Singleton Structure
//    companion object{
//        @Volatile private var instance: CarsDatabase ?= null
//        private val lock = Any()
//        operator fun invoke(context: Context) = instance ?: synchronized(lock){
//            instance ?: makeDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun makeDatabase(context: Context) =
//            Room.databaseBuilder(context.applicationContext, CarsDatabase::class.java, "carsdatabase")
//                .build()
//    }
//}
//
