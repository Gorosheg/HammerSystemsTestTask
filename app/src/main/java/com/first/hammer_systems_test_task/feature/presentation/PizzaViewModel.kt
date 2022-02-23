package com.first.hammer_systems_test_task.feature.presentation

import androidx.lifecycle.ViewModel
import com.first.hammer_systems_test_task.feature.data.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class PizzaViewModel(private val repository: PizzaRepository) : ViewModel() {


    val loadPizza = repository.loadPizza

}