package com.app.lab1

import androidx.lifecycle.ViewModel

class MyViewModel(myString: String) : ViewModel() {

    // Приватна змінна для зберігання рядка. Ініціалізується значенням, переданим у конструктор.
    private var _myString = myString

    // Публічний геттер, що дозволяє отримати поточне значення рядка.
    val str: String
        get() = _myString

    // Функція для зміни значення рядка.
    fun changeString(s: String) {
        _myString = s
    }
}
