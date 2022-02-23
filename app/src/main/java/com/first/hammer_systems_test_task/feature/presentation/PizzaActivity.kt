package com.first.hammer_systems_test_task.feature.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.di.PizzaDi
import com.first.hammer_systems_test_task.feature.presentation.goodsRecycler.GoodsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class PizzaActivity : AppCompatActivity() {

    private var disposable = CompositeDisposable()
    private val di by lazy { PizzaDi.instance }
    private val goodsRecycler: RecyclerView by lazy { findViewById(R.id.goodsRecycler) }

    private val viewModel: PizzaViewModel by lazy {
        ViewModelProvider(this, di.viewModelFactory)
            .get(PizzaViewModel::class.java)
    }

    private val goodsAdapter: GoodsAdapter by lazy { GoodsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goodsRecycler.layoutManager = LinearLayoutManager(this)
        goodsRecycler.adapter = goodsAdapter

        loadPizza()

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun loadPizza() {
        disposable += viewModel.loadPizza
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pizza ->
                goodsAdapter.items = pizza
            }
    }

}