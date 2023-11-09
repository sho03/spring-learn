package com.example.multidb.domain.user

interface UserRepository {

    fun getAllUser(): List<User>

    fun saveUser(user: User)
}