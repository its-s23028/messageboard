package jp.ac.it_college.std.s23028.messeagrbord.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException(override val message: String?) : Exception()

@ResponseStatus(HttpStatus.CONFLICT)
class UserAlreadyExistsException(override val message: String?) : Exception(message)