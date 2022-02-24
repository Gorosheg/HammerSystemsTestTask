package com.first.hammer_systems_test_task.feature.presentation.pizzaRecycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.common.model.Pizza

class PizzaViewHolder(pizzaView: View) : RecyclerView.ViewHolder(pizzaView) {

    private val pizzaTitle: TextView = pizzaView.findViewById(R.id.title)
    private val pizzaDescription: TextView = pizzaView.findViewById(R.id.description)

    fun bind(pizza: Pizza) {
        pizzaTitle.text = pizza.name
        pizzaDescription.text = pizza.description
    }
}