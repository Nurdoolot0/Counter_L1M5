package com.example.counter_l1m5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.counter_l1m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {

    private val presenter = CounterPresenter()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        presenter.attachCounterContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachCounterContract()
    }
}