package com.first.hammer_systems_test_task.feature.presentation

import androidx.lifecycle.ViewModel
import com.first.hammer_systems_test_task.common.model.Pizza
import com.first.hammer_systems_test_task.feature.data.PizzaRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PizzaViewModel(private val repository: PizzaRepository) : ViewModel() {

    fun loadPizza(): Observable<List<Pizza>> {
        return repository.loadPizza()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

}