package com.qima.ldaptest

class UserNotFoundException(private val userId: String) : Exception("User $userId is not found")