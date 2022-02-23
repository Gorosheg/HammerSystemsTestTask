package com.first.hammer_systems_test_task.feature.data

import com.first.hammer_systems_test_task.common.model.Pizza
import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasource
import io.reactivex.Single

class PizzaRepositoryImpl(private val network: NetworkDatasource) : PizzaRepository {

    override val loadPizza: Single<List<Pizza>> = network.loadPizza()
    /*.doOnSuccess { }*/ //todo: add to db

}
