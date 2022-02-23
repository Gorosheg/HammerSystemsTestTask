package com.first.hammer_systems_test_task.dataSource.network

import com.first.hammer_systems_test_task.dataSource.network.model.PizzaResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface PizzaApi {

    @GET("/v2/currencies")
    fun getPizza(): Single<PizzaResponse>

}