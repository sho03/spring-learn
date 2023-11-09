package com.example.multidb.domain

interface UserRepository {

    fun getAllUser(): List<User>

    fun saveUser(user: User)
}