package com.example.multidb.exposed.table

import org.jetbrains.exposed.sql.Table

object UserTable : Table("user") {

    val name = varchar("name", 50)
    val age = integer("age")
}