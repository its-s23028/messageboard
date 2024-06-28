package jp.ac.it_college.std.s23028.messeagrbord.infasture.database.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Messages
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.MessageRepository
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.MessagesEntity
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.MessagesTables
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.ThreadsEntity
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository


@Repository
class MessagesRepositoryImplImpl : MessageRepository {
    override fun createMessage(message: Messages): Messages {
        return transaction {
            val newMessage = MessagesEntity.new {
                threadId = ThreadsEntity[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                updatedAt = message.updateAt
                deleted = message.deleted
            }
            newMessage.toMessages()
        }
    }
    override fun getMessageById(id: Long): Messages? {
        return transaction {
            val message = MessagesEntity.findById(id)
            message?.toMessages()
        }
    }

    override fun getMessageByThreadId(threadId: Long): List<Messages> {
       return transaction {
           MessagesEntity.find { MessagesTables.threadId eq threadId }
               .map { it.toMessages() }
       }
    }

    override fun updateMessage(message: Messages): Messages {
        return transaction {
            val messagesEntity = MessagesEntity.findById(message.id)
                ?: throw IllegalArgumentException("Message not found with id: ${message.id}")
            messagesEntity.apply {
                threadId = ThreadsEntity[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.updateAt
                deleted = message.deleted
            }
            messagesEntity.toMessages()
        }
    }

    override fun deleteMessage(id: Long) {
        transaction {
            MessagesEntity.findById(id)?.delete()
        }

    }
}