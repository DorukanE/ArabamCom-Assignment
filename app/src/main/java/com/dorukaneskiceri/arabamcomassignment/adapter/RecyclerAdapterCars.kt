package com.dorukaneskiceri.arabamcomassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dorukaneskiceri.arabamcomassignment.R
import com.dorukaneskiceri.arabamcomassignment.model.CarsModel
import kotlinx.android.synthetic.main.recyclerview_cars.view.*

class RecyclerAdapterCars(private val arrayListCars: ArrayList<CarsModel>) :
    RecyclerView.Adapter<RecyclerAdapterCars.CarsHolder>() {

    override fun getItemCount(): Int {
        return arrayListCars.size
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        holder.view.textViewPrice.text = arrayListCars[position].advertisementPriceFormatted
        holder.view.textViewTitle.text = arrayListCars[position].advertisementTitle
        holder.view.textViewLocation.text =
            arrayListCars[position].advertisementLocation?.cityName + arrayListCars[position].advertisementLocation?.townName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerview_cars, parent, false)
        return CarsHolder(view)
    }

    class CarsHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    fun updateLayout(listCars: List<CarsModel>) {
        arrayListCars.clear()
        arrayListCars.addAll(listCars)
        notifyDataSetChanged()
    }
}