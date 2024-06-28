package jp.ac.it_college.std.s23028.messeagrbord.domain.repository

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Threads
import org.springframework.stereotype.Repository


@Repository
interface ThreadsRepository {
    fun createThread(thread: Threads): Threads
    fun getThreadById(id: Long): Threads?
    fun getAllThreads(): List<Threads>
    fun updateThread(thread: Threads): Threads
    fun deleteThread(id: Long)
}