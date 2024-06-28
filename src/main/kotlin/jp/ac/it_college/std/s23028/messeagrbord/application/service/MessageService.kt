package jp.ac.it_college.std.s23028.messeagrbord.application.service

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Messages
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.MessageRepository


class MessageService(
    private val messageRepository: MessageRepository
) {
    fun createMessage(message: Messages): Messages {
        return messageRepository.createMessage(message)
    }
}