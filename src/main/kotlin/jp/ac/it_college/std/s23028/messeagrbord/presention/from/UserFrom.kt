package jp.ac.it_college.std.s23028.messeagrbord.presention.from

import kotlinx.serialization.Serializable


@Serializable
data class UserRegisterRequest(
    val email: String,
    val password: String,
    val viewName: String
)

@Serializable
data class UserLoginRequest(
    val email: String,
    val password: String
)