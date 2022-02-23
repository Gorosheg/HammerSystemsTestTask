package com.first.hammer_systems_test_task.dataSource.network

import com.first.hammer_systems_test_task.common.Pizza
import com.first.hammer_systems_test_task.dataSource.network.model.PizzaResponse
import io.reactivex.Single

interface PizzaDatasource {
    fun loadingPizzaInfo(): Single<Pizza>
}

internal class NetworkDatasource(private val api: PizzaApi) : PizzaDatasource {

    override fun loadingPizzaInfo(): Single<Pizza> {
        return api.getPizza().map { it.toPizza() }
    }

    private fun PizzaResponse.toPizza(): Pizza {
return Pizza()
    }
}