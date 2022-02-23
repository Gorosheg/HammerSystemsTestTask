package com.first.hammer_systems_test_task.feature.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.di.PizzaDi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class PizzaActivity : AppCompatActivity() {

    private var disposable = CompositeDisposable()
    private val di by lazy { PizzaDi.instance }

    private val viewModel: PizzaViewModel by lazy {
        ViewModelProvider(this, di.viewModelFactory)
            .get(PizzaViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            }
    }

}