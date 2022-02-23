package com.first.hammer_systems_test_task.dataSource.network.model

import com.google.gson.annotations.SerializedName

internal class PizzaResponse(
    @SerializedName("data")
    private val content: List<ContentResponse>
)