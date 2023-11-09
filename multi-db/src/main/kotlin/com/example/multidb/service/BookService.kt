package com.example.multidb.service

import com.example.multidb.domain.book.Book
import com.example.multidb.domain.book.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    @Transactional(transactionManager = "secondaryTransactionManager", propagation = Propagation.REQUIRED)
    fun getAllBook() = bookRepository.getAllBook()

    @Transactional(transactionManager = "secondaryTransactionManager", propagation = Propagation.REQUIRED)
    fun saveBook(name: String, author: String): Book {
        val book = Book(name, author)
        bookRepository.saveBook(book)
        return book
    }
}
