package com.first.hammer_systems_test_task.dataSource.network

import com.first.hammer_systems_test_task.common.model.Pizza
import com.first.hammer_systems_test_task.dataSource.network.model.PizzaResponse
import io.reactivex.Single

interface NetworkDatasource {
    fun loadPizza(): Single<List<Pizza>>
}

internal class NetworkDatasourceImpl(private val api: PizzaApi) : NetworkDatasource {

    override fun loadPizza(): Single<List<Pizza>> {
        return api.getPizza().map { it.toPizza() }
    }

    private fun PizzaResponse.toPizza(): List<Pizza> {
        return content.map {
            Pizza(it.title, it.description)
        }
    }
}