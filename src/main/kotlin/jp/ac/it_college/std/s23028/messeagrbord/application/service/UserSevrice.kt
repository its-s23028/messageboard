package jp.ac.it_college.std.s23028.messeagrbord.application.service

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Users
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.UsersRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserSevrice (
    private val usersRepository: UsersRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(viewName: String, email: String, password: String): Users {
        println("Registering user with email: $email")
        val hashedPassword = passwordEncoder.encode(password)
        val user = Users(
            id = 0,
            email,
            hashedPassword,
            viewName
        )
        return usersRepository.createUser(user)
    }
    fun findByEmail(email: String): Users? {
        println("Finding user by email: $email")
        return usersRepository.findByEmail(email)
    }
}