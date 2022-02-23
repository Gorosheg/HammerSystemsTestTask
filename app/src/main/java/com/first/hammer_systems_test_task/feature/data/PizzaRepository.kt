package com.first.hammer_systems_test_task.feature.data

import com.first.hammer_systems_test_task.common.model.Pizza
import io.reactivex.Single

interface PizzaRepository {

    val loadPizza: Single<List<Pizza>>

}