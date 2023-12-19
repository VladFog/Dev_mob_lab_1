package com.app.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Оголошення змінної для ViewModel
    private lateinit var viewModel: MyViewModel

    // Оголошення змінної для binding, яка дозволить взаємодіяти з елементами UI
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ініціалізація binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ініціалізація ViewModel з використанням ViewModelProvider та фабрики
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(resources.getString(R.string.my_string))
        )[MyViewModel::class.java]

        // Встановлення тексту в textView зі значенням з ViewModel
        binding.textView.text = viewModel.str

        // Обробник кліків для кнопки
        binding.button.setOnClickListener {
            // Отримання нового рядка ресурсів
            val newStr = resources.getString(R.string.new_string)
            // Оновлення рядка в ViewModel
            viewModel.changeString(newStr)
            // Оновлення тексту в textView
            binding.textView.text = viewModel.str
        }
    }
}
