package com.first.hammer_systems_test_task.di

import android.content.Context
import androidx.room.Room
import com.first.hammer_systems_test_task.dataSource.databace.DatabaseDatasource
import com.first.hammer_systems_test_task.dataSource.databace.DatabaseDatasourceImpl
import com.first.hammer_systems_test_task.dataSource.databace.PizzaDao
import com.first.hammer_systems_test_task.dataSource.databace.PizzaDatabase
import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasource
import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasourceImpl
import com.first.hammer_systems_test_task.dataSource.network.PizzaApi
import com.first.hammer_systems_test_task.feature.data.PizzaRepository
import com.first.hammer_systems_test_task.feature.data.PizzaRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PizzaDi(context: Context) {

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

    private val database: PizzaDatabase =
        Room.databaseBuilder(context, PizzaDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()

    private val cityDao: PizzaDao = database.pizzaDao
    private val datasource: DatabaseDatasource = DatabaseDatasourceImpl(cityDao)
    private val networkDataSource: NetworkDatasource = NetworkDatasourceImpl(api)

    private val repository: PizzaRepository
        get() = PizzaRepositoryImpl(networkDataSource, datasource)

    val viewModelFactory: PizzaViewModelFactory
        get() = PizzaViewModelFactory(repository)

    companion object {

        lateinit var instance: PizzaDi

    }

}