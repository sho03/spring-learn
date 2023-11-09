package com.example.multidb.domain.book

interface BookRepository {

    fun getAllBook(): List<Book>

    fun saveBook(book: Book)
}