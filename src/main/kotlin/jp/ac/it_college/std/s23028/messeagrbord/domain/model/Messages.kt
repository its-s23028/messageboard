package jp.ac.it_college.std.s23028.messeagrbord.domain.model

import kotlinx.datetime.LocalDateTime

data class Messages(
    val id: Long,
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val deleted: Boolean
)