package jp.ac.it_college.std.s23028.messeagrbord.presention.controller

import jp.ac.it_college.std.s23028.messeagrbord.application.service.UserSevrice
import jp.ac.it_college.std.s23028.messeagrbord.presention.from.UserLoginRequest
import jp.ac.it_college.std.s23028.messeagrbord.presention.from.UserRegisterRequest
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(
    private val userSevrice: UserSevrice,
){
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody request: UserRegisterRequest) {
        run {
            userSevrice.register(request.email, request.viewName, request.password)
        }
    }
//    @PostMapping("/login")
//    fun login(@RequestBody request: UserLoginRequest): Authentication{
//        println("Attempting to authenticate user: ${request.email}")
//        val authentication = authenticationManager.authenticate(
//            UsernamePasswordAuthenticationToken(request.email, request.password)
//        )
//        SecurityContextHolder.getContext().authentication = authentication
//        println("User authenticated: ${request.email}")
//        return authentication
//    }
}