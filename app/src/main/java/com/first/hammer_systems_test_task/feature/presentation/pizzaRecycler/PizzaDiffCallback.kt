package com.first.hammer_systems_test_task.feature.presentation.pizzaRecycler

import androidx.recyclerview.widget.DiffUtil
import com.first.hammer_systems_test_task.common.model.Pizza

class PizzaDiffCallback (
    private val oldList: List<Pizza>,
    private val newList: List<Pizza>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPizza = oldList[oldItemPosition]
        val newPizza = newList[newItemPosition]
        return oldPizza.name == newPizza.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPizza = oldList[oldItemPosition]
        val newPizza = newList[newItemPosition]
        return oldPizza == newPizza
    }
}