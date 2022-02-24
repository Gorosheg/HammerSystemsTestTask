package com.first.hammer_systems_test_task.dataSource.databace

import androidx.room.Database
import androidx.room.RoomDatabase
import com.first.hammer_systems_test_task.dataSource.databace.model.PizzaEntity

@Database(entities = [PizzaEntity::class], version = 1)
internal abstract class PizzaDatabase : RoomDatabase() {
    abstract val pizzaDao: PizzaDao
}