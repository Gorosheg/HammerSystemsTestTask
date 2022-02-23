package com.first.hammer_systems_test_task.dataSource.network

import com.first.hammer_systems_test_task.common.Pizza
import com.first.hammer_systems_test_task.dataSource.network.model.PizzaResponse
import io.reactivex.Single

interface PizzaDatasource {
    fun loadingPizzaInfo(): Single<MutableList<Pizza>>
}

internal class NetworkDatasource(private val api: PizzaApi) : PizzaDatasource {

    override fun loadingPizzaInfo(): Single<MutableList<Pizza>> {
        return api.getPizza().map { it.toPizza() }
    }

    private fun PizzaResponse.toPizza(): MutableList<Pizza> {
        val pizzaList: MutableList<Pizza> = mutableListOf()

        for (i in 0..content.size) {
            pizzaList.add(Pizza(content[i].title, content[i].description))
        }

        return pizzaList
    }
}