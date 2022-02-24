package com.first.hammer_systems_test_task.dataSource.databace

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.first.hammer_systems_test_task.dataSource.databace.model.PizzaEntity
import io.reactivex.Observable

@Dao
internal interface PizzaDao {

    @Insert
    fun insert(pizza: PizzaEntity)

    @Query("SELECT * FROM PizzaEntity")
    fun getPizza(): Observable<List<PizzaEntity>>

}