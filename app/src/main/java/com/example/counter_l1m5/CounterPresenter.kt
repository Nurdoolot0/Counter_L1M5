package com.example.counter_l1m5

import android.graphics.Color


class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterContract? = null

    fun attachCounterContract(view: CounterContract) {
        this.view = view
    }

    fun detachCounterContract() {
        view = null
    }

    fun onIncrement() {
        model.increment()
        updateView()
    }

    fun onDecrement() {
        model.decrement()
        updateView()
    }

    private fun updateView() {
        val count = model.getResult()
        view?.showResult(count)
        if (count == 10) {
            view?.showToast("Поздравляем!")
        }
        if (count == 15) {
            view?.changeTextColor(Color.GREEN)
        } else {
            view?.changeTextColor(Color.BLACK)
        }
    }
}