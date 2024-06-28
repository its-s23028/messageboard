package jp.ac.it_college.std.s23028.messeagrbord.domain.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Users



interface UsersRepository {
    fun findByEmail(email: String): Users?

    fun findById(id: Long): Users?

    fun createUser(user: Users): Users

    fun updateUser(user: Users): Users?

    fun deleteUser(id : Long)

    fun sava(user: Users): Users
}