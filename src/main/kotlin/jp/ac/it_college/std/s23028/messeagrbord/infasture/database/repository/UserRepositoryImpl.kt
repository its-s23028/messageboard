package jp.ac.it_college.std.s23028.messeagrbord.infasture.database.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Users
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.UsersRepository
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.UsersEntity
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.UsersTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UsersRepository {
    override fun findByEmail(email: String): Users? {
        return transaction {
            UsersEntity.find { UsersTable.email eq email }
                .singleOrNull()
                ?.toUser()
        }
    }

    override fun findById(id: Long): Users? {
        return transaction {
            UsersEntity.findById(id)?.toUser()
        }
    }

    override fun createUser(user: Users): Users {
        return transaction {
            UsersEntity.new {
                this.email = user.email
                this.password = user.password
                this.viewName = user.viewName
            }.toUser()
        }
    }

    override fun updateUser(user: Users): Users {
        return transaction {
            val usersEntity = UsersEntity.findById(user.id)
                ?: throw IllegalStateException("User not found with id ${user.id}")
            usersEntity.apply {
                email = user.email
                password = user.password
                viewName = user.viewName
            }
            usersEntity.toUser()
        }
    }

    override fun deleteUser(id: Long) {
        transaction {
            val usersEntity = UsersEntity.findById(id)
                ?: throw IllegalStateException("User not found with id ${id}")
            usersEntity.delete()
        }
    }

    override fun sava(user: Users): Users {
        return if (user.id == 0L) {
            createUser(user)
        } else {
            updateUser(user)
        }
    }
}