package com.dorukaneskiceri.arabamcomassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dorukaneskiceri.arabamcomassignment.R
import com.dorukaneskiceri.arabamcomassignment.databinding.RecyclerviewCarsBinding
import com.dorukaneskiceri.arabamcomassignment.service.CarsModel
import com.dorukaneskiceri.arabamcomassignment.util.downloadImage
import kotlinx.android.synthetic.main.recyclerview_cars.view.*

class RecyclerAdapterCars(private val arrayListCars: ArrayList<CarsModel>) :
    RecyclerView.Adapter<RecyclerAdapterCars.CarsHolder>() {

    override fun getItemCount(): Int {
        return arrayListCars.size
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        holder.view.cars = arrayListCars[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecyclerviewCarsBinding>(inflater, R.layout.recyclerview_cars, parent, false)
        return CarsHolder(view)
    }

    class CarsHolder(val view: RecyclerviewCarsBinding) : RecyclerView.ViewHolder(view.root) {

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