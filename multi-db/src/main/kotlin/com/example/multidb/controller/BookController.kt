package com.example.multidb.controller

import com.example.multidb.domain.book.Book
import com.example.multidb.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService
) {

    @GetMapping("/books")
    fun getAllBook(): List<Book> {
        return bookService.getAllBook()
    }

    @PostMapping("/books")
    fun saveBook(
        @RequestBody request: BookRequestBody
    ): Book {
        return bookService.saveBook(request.name, request.author)
    }

    data class BookRequestBody(
        val name: String,
        val author: String
    )
}