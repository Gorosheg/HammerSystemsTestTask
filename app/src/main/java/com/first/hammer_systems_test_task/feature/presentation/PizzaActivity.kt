package com.first.hammer_systems_test_task.feature.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.di.PizzaDi
import com.first.hammer_systems_test_task.feature.presentation.pizzaRecycler.PizzaAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class PizzaActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val di by lazy { PizzaDi.instance }
    private val recycler: RecyclerView by lazy { findViewById(R.id.pizzaRecycler) }
    private val adapter: PizzaAdapter by lazy { PizzaAdapter() }

    private val viewModel: PizzaViewModel by lazy {
        ViewModelProvider(this, di.viewModelFactory)
            .get(PizzaViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter
        loadPizza()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun loadPizza() {
        disposable += viewModel.loadPizza()
            .subscribe { pizza ->
                adapter.items = pizza
            }
    }

}