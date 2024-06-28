package jp.ac.it_college.std.s23028.messeagrbord.domain.model

import kotlinx.datetime.LocalDateTime

data class Threads (
    val id : Long,
    val title : String,
    val user_id : Long,
    val created_at : LocalDateTime,
    val updated_at : LocalDateTime,
    val deleted : Boolean,
)
