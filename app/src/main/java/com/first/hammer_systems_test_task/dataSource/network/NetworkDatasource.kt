package com.first.hammer_systems_test_task.dataSource.network

import com.first.hammer_systems_test_task.common.Pizza
import io.reactivex.Single

interface PizzaDatasource {
    fun loadingPizzaInfo()/*: Single<Pizza>*/
}

internal class NetworkDatasource(private val api: PizzaApi) : PizzaDatasource {

    override fun loadingPizzaInfo()/*: Single<Pizza> */ {
        /*return*/ api.getPizza(
            from = 0,
            size = 15,
            tags = "under_30_minutes"
        )//.map { it.toPizza() }
    }


    private fun PizzaResponse.toPizza()/*:Pizza*/ {

    }
}