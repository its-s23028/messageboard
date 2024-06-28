package jp.ac.it_college.std.s23028.messeagrbord.infasture.database.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Threads
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.ThreadsRepository
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.ThreadsEntity
import jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import kotlin.concurrent.thread


@Repository
class ThreadsRepositoryImpl : ThreadsRepository {
    override fun createThread(thread: Threads): Threads {
        return transaction{
            val newThread = ThreadsEntity.new {
                title = thread.title
                userId = UsersEntity[thread.user_id]
                createdAt = thread.created_at
                updatedAt = thread.updated_at
                deleted = thread.deleted
            }
            newThread.toThread()
        }
    }

    override fun getThreadById(id: Long): Threads? {
       return transaction {
           val threadsEntity = ThreadsEntity.findById(id)
           threadsEntity?.toThread()
       }
    }

    override fun getAllThreads(): List<Threads> {
        return transaction {
            ThreadsEntity.all().map { it.toThread() }
        }
    }

    override fun updateThread(thread: Threads): Threads {
        return transaction {
            val threadEntity = ThreadsEntity.findById(thread.id)
                ?: throw IllegalArgumentException("Threads not found with id: ${thread.id}")

            threadEntity.apply {
                title = thread.title
                userId = UsersEntity[thread.user_id]
                createdAt = thread.created_at
                updatedAt = thread.updated_at
                deleted = thread.deleted
            }
            threadEntity.toThread()
        }
    }

    override fun deleteThread(id: Long) {
        transaction {
            ThreadsEntity.findById(id)?.delete()
        }
    }
}