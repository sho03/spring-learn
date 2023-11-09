package com.example.multidb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiDbApplication

fun main(args: Array<String>) {
	runApplication<MultiDbApplication>(*args)
}
