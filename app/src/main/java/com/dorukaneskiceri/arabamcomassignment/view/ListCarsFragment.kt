package com.dorukaneskiceri.arabamcomassignment.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorukaneskiceri.arabamcomassignment.R
import com.dorukaneskiceri.arabamcomassignment.adapter.RecyclerAdapterCars
import com.dorukaneskiceri.arabamcomassignment.viewmodel.CarsListViewModel
import kotlinx.android.synthetic.main.fragment_list_cars.*

class ListCarsFragment : Fragment() {

    private lateinit var carsListViewModel: CarsListViewModel
    private val adapter = RecyclerAdapterCars(arrayListOf())
    private var isScrolling = false
    private var take = 10
    private var skip = 0
    private var currentItems = 1
    private var totalItems = 1
    private var scrollOutItems = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_cars, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carsListViewModel = ViewModelProviders.of(this).get(CarsListViewModel::class.java)

        recyclerViewCars.layoutManager = LinearLayoutManager(view.context)
        carsListViewModel.getCarsList(take,0)
        recyclerViewCars.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener {
            skip+=take
            carsListViewModel.getCarsList(take,skip)
            swipeRefreshLayout.isRefreshing = false
        }

        recyclerViewCars.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItems = LinearLayoutManager(view.context).childCount
                totalItems = LinearLayoutManager(view.context).itemCount
                scrollOutItems = LinearLayoutManager(view.context).findFirstVisibleItemPosition()

                if(isScrolling && (currentItems + scrollOutItems == totalItems)){
                    isScrolling = false
                    skip += take
                    carsListViewModel.getCarsList(take, skip)
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true
                }
            }
        })

        observe()
    }

    private fun observe() {
        carsListViewModel.carsList.observe(viewLifecycleOwner, { carsList ->
            carsList?.let {
                adapter.updateLayout(it)
            }
        })

        carsListViewModel.loadingState.observe(viewLifecycleOwner, { loadingState ->
            loadingState?.let {
                if(it){
                    progressBar.visibility = View.VISIBLE
                    textViewError. visibility = View.INVISIBLE
                }else{
                    progressBar.visibility = View.INVISIBLE
                }
            }
        })

        carsListViewModel.errorState.observe(viewLifecycleOwner, { errorState ->
            errorState?.let {
                if(it){
                    textViewError.visibility = View.VISIBLE
                }else{
                    textViewError.visibility = View.INVISIBLE
                }
            }
        })
    }
}