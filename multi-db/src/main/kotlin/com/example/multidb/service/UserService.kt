package com.example.multidb.service

import com.example.multidb.domain.user.User
import com.example.multidb.domain.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun getAllUser(): List<User> {
        return userRepository.getAllUser()
    }

    @Transactional
    fun saveUser(name: String, age: Int): User {
        val user = User(name, age)
        userRepository.saveUser(user)
        return user
    }
}
