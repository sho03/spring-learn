package com.example.multidb.controller

import com.example.multidb.domain.user.User
import com.example.multidb.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/users")
    fun getAllUser(): List<User> {
        return userService.getAllUser()
    }

    @PostMapping("/users")
    fun saveUser(
        @RequestBody request: UserRequestBody
    ): User {
        return userService.saveUser(request.name, request.age)
    }


    data class UserRequestBody(
        val name: String,
        val age: Int
    )
}