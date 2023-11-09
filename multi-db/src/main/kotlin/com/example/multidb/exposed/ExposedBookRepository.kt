package com.example.multidb.exposed

import com.example.multidb.domain.book.Book
import com.example.multidb.domain.book.BookRepository
import com.example.multidb.exposed.table.BookTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository

@Repository
class ExposedBookRepository : BookRepository {
    override fun getAllBook(): List<Book> {
        val query = BookTable.selectAll()
        return query.map { row ->
            Book(
                name = row[BookTable.name],
                author = row[BookTable.author]
            ) }
    }

    override fun saveBook(book: Book) {
        BookTable.insert {
            it[name] = book.name
            it[author] = book.author
        }
    }
}