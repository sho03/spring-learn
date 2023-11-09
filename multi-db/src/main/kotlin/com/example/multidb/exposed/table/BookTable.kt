package com.example.multidb.exposed.table

import org.jetbrains.exposed.sql.Table

object BookTable : Table("book") {

    val name = varchar("name", 50)
    val author = varchar("author", 50)
}
