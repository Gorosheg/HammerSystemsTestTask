package com.first.hammer_systems_test_task.feature.presentation.goodsRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.common.model.Pizza

class GoodsViewHolder(PizzaView: View) : RecyclerView.ViewHolder(PizzaView) {

    private val pizzaTitle: TextView = PizzaView.findViewById(R.id.title)
    private val pizzaDescription: TextView = PizzaView.findViewById(R.id.description)

    fun bind(pizza: Pizza) {
        this.pizzaTitle.text = pizza.name
        this.pizzaDescription.text = pizza.description
    }
}