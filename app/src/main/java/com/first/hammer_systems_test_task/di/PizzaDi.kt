package com.first.hammer_systems_test_task.di

import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasource
import com.first.hammer_systems_test_task.dataSource.network.PizzaApi
import com.first.hammer_systems_test_task.dataSource.network.PizzaDatasource
import com.first.hammer_systems_test_task.feature.data.PizzaRepository
import com.first.hammer_systems_test_task.feature.data.PizzaRepositoryImpl
import com.first.hammer_systems_test_task.feature.presentation.PizzaViewModelFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PizzaDi() {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val api: PizzaApi = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.coinbase.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PizzaApi::class.java)

    private val networkDataSource: PizzaDatasource = NetworkDatasource(api)

    private val repository: PizzaRepository
        get() = PizzaRepositoryImpl(networkDataSource)

    val viewModelFactory: PizzaViewModelFactory
        get() = PizzaViewModelFactory(repository)

    companion object {

        lateinit var instance: PizzaDi

    }

}