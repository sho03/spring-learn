package com.example.client.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ClientService {

    fun fetchApi(): Mono<String> {
        // 外部のAPIサーバへのリクエストを模倣する
        val webClient = WebClient.create("http://localhost:8089")

        // Mono<T>を返却する
        return webClient.get()
            .uri("/api")
            .retrieve()
            .bodyToMono(String::class.java)
    }
}