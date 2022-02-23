package com.first.hammer_systems_test_task.dataSource.network.model

import com.google.gson.annotations.SerializedName

class ContentResponse(

    @SerializedName("id")
    val title: String,

    @SerializedName("name")
    val description: String

)