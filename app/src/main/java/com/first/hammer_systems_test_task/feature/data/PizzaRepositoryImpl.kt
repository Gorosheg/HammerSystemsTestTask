package com.first.hammer_systems_test_task.feature.data

import com.first.hammer_systems_test_task.common.model.Pizza
import com.first.hammer_systems_test_task.dataSource.databace.DatabaseDatasource
import com.first.hammer_systems_test_task.dataSource.network.NetworkDatasource
import io.reactivex.Observable

internal class PizzaRepositoryImpl(
    private val network: NetworkDatasource,
    private val database: DatabaseDatasource
) : PizzaRepository {

    override fun loadPizza(): Observable<List<Pizza>> {
        return Observable.merge(
            loadPizzaFromDatabase(),
            loadPizzaFromNetwork()
        ).distinctUntilChanged()
    }

    private fun loadPizzaFromDatabase(): Observable<List<Pizza>> {
        return database.getPizza()
    }

    private fun loadPizzaFromNetwork(): Observable<List<Pizza>> {
        return network.loadPizza()
            .doOnSuccess { database.update(it) }
            .toObservable()
            .onErrorReturn { emptyList() }
            .filter { it.isNotEmpty() }
    }
}
