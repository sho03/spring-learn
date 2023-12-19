package com.example.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @GetMapping("/api")
    fun hello(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello world!")
    }
}
