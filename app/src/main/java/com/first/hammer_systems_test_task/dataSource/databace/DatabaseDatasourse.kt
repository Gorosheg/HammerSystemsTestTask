package com.first.hammer_systems_test_task.dataSource.databace

import com.first.hammer_systems_test_task.common.model.Pizza
import com.first.hammer_systems_test_task.dataSource.databace.model.PizzaEntity
import com.first.hammer_systems_test_task.dataSource.databace.model.toEntity
import com.first.hammer_systems_test_task.dataSource.databace.model.toSimplePizza
import io.reactivex.Observable

interface DatabaseDatasource {

    fun update(pizzaList: List<Pizza>)

    fun getPizza(): Observable<List<Pizza>>
}

internal class DatabaseDatasourceImpl(private val pizzaDao: PizzaDao) : DatabaseDatasource {

    override fun update(pizzaList: List<Pizza>) {
        pizzaList.map { pizza ->
            pizzaDao.insert(pizza.toEntity())
        }
    }

    override fun getPizza(): Observable<List<Pizza>> {
        return pizzaDao.getPizza()
            .map(List<PizzaEntity>::toSimplePizza)
    }
}

