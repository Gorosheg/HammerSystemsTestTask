package com.first.hammer_systems_test_task.feature.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.first.hammer_systems_test_task.R
import com.first.hammer_systems_test_task.di.PizzaDi

class PizzaActivity : AppCompatActivity() {

    private val di by lazy { PizzaDi.instance }

    private val viewModel: PizzaViewModel by lazy {
        ViewModelProvider(this, di.viewModelFactory)
            .get(PizzaViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}