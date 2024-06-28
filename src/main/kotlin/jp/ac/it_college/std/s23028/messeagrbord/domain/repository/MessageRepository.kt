package jp.ac.it_college.std.s23028.messeagrbord.domain.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Messages

interface MessageRepository {
    fun createMessage(message: Messages): Messages

    fun getMessageById(id: Long): Messages?

    fun getMessageByThreadId(threadId: Long): List<Messages>

    fun updateMessage(message: Messages): Messages

    fun deleteMessage(id: Long)
}