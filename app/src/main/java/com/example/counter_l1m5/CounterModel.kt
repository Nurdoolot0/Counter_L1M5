package com.example.counter_l1m5

class CounterModel {

    private var count = 0

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }

    fun getResult() = count
}