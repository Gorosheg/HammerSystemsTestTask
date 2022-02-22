package com.first.hammer_systems_test_task.dataSource.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PizzaApi {

    /**
     * Api request:
     * https://rapidapi.com/apidojo/api/tasty/
     */
    @GET("/recipes/list?from=0&size=20&tags=under_30_minutes")
    fun getPizza(
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Query("tags") tags: String
    ): Single<PizzaResponse>

}