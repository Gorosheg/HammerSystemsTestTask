package com.first.hammer_systems_test_task.feature.data

import com.first.hammer_systems_test_task.dataSource.network.PizzaDatasource

class PizzaRepositoryImpl(private val network: PizzaDatasource) : PizzaRepository {
}