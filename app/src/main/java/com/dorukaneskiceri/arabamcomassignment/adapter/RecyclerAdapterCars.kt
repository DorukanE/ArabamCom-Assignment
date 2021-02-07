package com.dorukaneskiceri.arabamcomassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dorukaneskiceri.arabamcomassignment.R
import com.dorukaneskiceri.arabamcomassignment.service.CarsModel
import com.dorukaneskiceri.arabamcomassignment.util.downloadImage
import kotlinx.android.synthetic.main.recyclerview_cars.view.*

class RecyclerAdapterCars(private val arrayListCars: ArrayList<CarsModel>) :
    RecyclerView.Adapter<RecyclerAdapterCars.CarsHolder>() {

    override fun getItemCount(): Int {
        return arrayListCars.size
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        holder.view.textViewPrice.text = arrayListCars[position].advertisementPriceFormatted
        holder.view.textViewTitle.text = arrayListCars[position].advertisementTitle
//        holder.view.textViewLocation.text = arrayListCars[position].advertisementLocation?.cityName + " / " + arrayListCars[position].advertisementLocation?.townName
//        holder.view.imageViewCar.downloadImage(arrayListCars[position].advertisementPhoto, holder.view.context)

        holder.view.textViewLocation.text = arrayListCars[position]?.advertisementLocation?.cityName + " / " + arrayListCars[position]?.advertisementLocation?.townName
        holder.view.imageViewCar.downloadImage(arrayListCars[position].advertisementPhoto, holder.view.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerview_cars, parent, false)
        return CarsHolder(view)
    }

    class CarsHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    fun updateLayout(listCars: List<CarsModel>, isRefreshed: Boolean): Boolean {
        if(isRefreshed){
            arrayListCars.clear()
            arrayListCars.addAll(listCars)
            notifyDataSetChanged()
            return false
        }else{
            arrayListCars.addAll(listCars)
            notifyDataSetChanged()
            return false
        }
    }

}