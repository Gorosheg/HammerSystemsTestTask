package com.first.hammer_systems_test_task

import android.app.Application
import com.first.hammer_systems_test_task.di.PizzaDi

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PizzaDi.instance = PizzaDi(this)
    }

}