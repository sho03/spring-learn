package com.example.hikaricpdemo.model

class User(
    private val name: String,
    private val age: Int) {

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Name cannot be empty")
        }
    }

    fun isAdult(): Boolean {
        return age >= 18
    }
}