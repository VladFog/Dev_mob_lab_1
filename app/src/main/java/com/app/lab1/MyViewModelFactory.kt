package com.app.lab1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private val myString: String) : ViewModelProvider.Factory {

    // Функція для створення екземпляра ViewModel.
    // Ця функція викликається, коли ви створюєте ViewModel за допомогою ViewModelProvider.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Перевіряємо, чи modelClass є або може бути приведений до MyViewModel
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            // Створюємо та повертаємо новий екземпляр MyViewModel з переданим рядком
            return MyViewModel(myString) as T
        }
        // Якщо переданий клас не є MyViewModel, кидаємо виключення
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
