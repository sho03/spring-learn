package com.example.client.controller

import com.example.client.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ClientController(
    private val clientService: ClientService
) {

    @GetMapping("/hello")
    fun fetchApi(): Mono<ResponseEntity<String>> {
        val result = clientService.fetchApi()
        return result.map { data -> ResponseEntity.ok(data) }
    }
}