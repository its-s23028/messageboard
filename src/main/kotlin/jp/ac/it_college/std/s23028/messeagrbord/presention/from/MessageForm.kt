package jp.ac.it_college.std.s23028.messeagrbord.presention.from

import jakarta.security.auth.message.MessageInfo
import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Messages
import kotlinx.datetime.LocalDateTime



data class GetMessagListResponse(val messageList: List<MessageInfo>)

data class RegisterUserRepository(
    val id : Long,
    val view_name : String,
    val email : String,
    val password : String
)

data class RegisterMessageResponse(
    val id : Long,
    val thread_id : Long,
    val user_id : Long,
    val message : String,
    val posted_at : LocalDateTime,
    val updated_at : LocalDateTime,
    val deleted : Boolean,
)