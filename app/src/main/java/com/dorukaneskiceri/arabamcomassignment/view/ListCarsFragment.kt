package com.dorukaneskiceri.arabamcomassignment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorukaneskiceri.arabamcomassignment.R
import com.dorukaneskiceri.arabamcomassignment.adapter.RecyclerAdapterCars
import kotlinx.android.synthetic.main.fragment_list_cars.*

class ListCarsFragment : Fragment() {

    private val adapter = RecyclerAdapterCars(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_cars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCars.layoutManager = LinearLayoutManager(view.context)
        recyclerViewCars.adapter = adapter

    }
}