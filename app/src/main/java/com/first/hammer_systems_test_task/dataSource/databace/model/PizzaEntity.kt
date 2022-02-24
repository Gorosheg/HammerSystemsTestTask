package com.first.hammer_systems_test_task.dataSource.databace.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.first.hammer_systems_test_task.common.model.Pizza

@Entity
internal data class PizzaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String
)

internal fun Pizza.toEntity() = PizzaEntity(
    name = name ?: "",
    description = description ?: "",
)

internal fun List<PizzaEntity>.toSimplePizza(): List<Pizza> = map { pizza ->
    pizza.toSimplePizza()
}

internal fun PizzaEntity.toSimplePizza() = Pizza(
    name = name,
    description = description
)
