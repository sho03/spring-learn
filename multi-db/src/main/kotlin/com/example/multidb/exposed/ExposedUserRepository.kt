package com.example.multidb.exposed

import com.example.multidb.domain.User
import com.example.multidb.domain.UserRepository
import com.example.multidb.exposed.table.UserTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository

@Repository
class ExposedUserRepository : UserRepository {

    override fun getAllUser(): List<User> {
        val query = UserTable.selectAll()
        return query.map {
            User(
                name = it[UserTable.name],
                age = it[UserTable.age]
            )
        }
    }

    override fun saveUser(user: User) {
        UserTable.insert {
            it[name] = user.name
            it[age] = user.age
        }
    }
}