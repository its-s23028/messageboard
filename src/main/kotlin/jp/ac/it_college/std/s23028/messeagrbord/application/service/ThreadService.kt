package jp.ac.it_college.std.s23028.messeagrbord.application.service

import jp.ac.it_college.std.s23028.messeagrbord.domain.model.Threads
import jp.ac.it_college.std.s23028.messeagrbord.domain.repository.ThreadsRepository
import org.springframework.stereotype.Service


@Service
class ThreadService (
    private val threadsRepository: ThreadsRepository
){
    fun createThread(thread: Threads): Threads{
        return threadsRepository.createThread(thread)
    }
}