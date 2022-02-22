package com.first.hammer_systems_test_task.feature.di

import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasource
import com.first.hammer_systems_test_task.dataSource.network.PizzaApi
import com.first.hammer_systems_test_task.dataSource.network.PizzaDatasource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PizzaDi {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val api: PizzaApi = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://tasty.p.rapidapi.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PizzaApi::class.java)

    val networkDataSource: PizzaDatasource = NetworkDatasource(api)

}