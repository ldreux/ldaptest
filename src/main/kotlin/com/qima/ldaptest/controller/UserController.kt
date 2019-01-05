package com.qima.ldaptest.controller

import com.qima.ldaptest.UserNotFoundException
import com.qima.ldaptest.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/users/{userId}")
    fun findUser(@PathVariable userId: String) = userService.findUser(userId)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException::class)
    fun handleException(exception: UserNotFoundException) = exception
}