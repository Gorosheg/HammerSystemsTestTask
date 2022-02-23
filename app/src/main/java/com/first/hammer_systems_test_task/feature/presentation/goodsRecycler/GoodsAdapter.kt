package com.first.hammer_systems_test_task.feature.presentation.goodsRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.common.model.Pizza

class GoodsAdapter() : RecyclerView.Adapter<GoodsViewHolder>() {
    var items: List<Pizza> = emptyList()
        set(value) {
            val diffResult = DiffUtil.calculateDiff(GoodsDiffCallback(items, value))
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val pizzaView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_goods, parent, false)
        return GoodsViewHolder(pizzaView)
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
