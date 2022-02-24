package com.first.hammer_systems_test_task.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.first.hammer_systems_test_task.feature.data.PizzaRepository
import com.first.hammer_systems_test_task.feature.presentation.PizzaViewModel

class PizzaViewModelFactory(private val repository: PizzaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PizzaViewModel(repository) as T
    }
}