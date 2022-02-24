package com.first.hammer_systems_test_task.feature.presentation.pizzaRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.common.model.Pizza

internal class PizzaAdapter : RecyclerView.Adapter<PizzaViewHolder>() {

    var items: List<Pizza> = emptyList()
        set(value) {
            val diffResult = DiffUtil.calculateDiff(PizzaDiffCallback(items, value))
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val pizzaView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_pizza, parent, false)
        return PizzaViewHolder(pizzaView)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
