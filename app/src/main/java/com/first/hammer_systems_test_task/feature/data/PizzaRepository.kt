package com.first.hammer_systems_test_task.feature.data

import com.first.hammer_systems_test_task.common.model.Pizza
import io.reactivex.Observable
import io.reactivex.Single

interface PizzaRepository {

    fun loadPizza(): Observable<List<Pizza>>

}