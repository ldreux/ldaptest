package com.qima.ldaptest.service

import com.qima.ldaptest.UserNotFoundException
import com.qima.ldaptest.model.User
import com.qima.ldaptest.repository.LdapRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val ldapRepository: LdapRepository) {
    fun findUser(userId: String) = if (ldapRepository.exists("user;$userId")) {
        User(userId, getGroups(userId))
    } else {
        throw UserNotFoundException(userId)
    }

    fun getGroups(userId: String) = findGroups("user;$userId", emptySet()).map { it.replace("group;", "") }.sorted()

    private fun findGroups(ldapId: String, results: Set<String>): Set<String> {
        val groups = ldapRepository.getGroups(ldapId).filter { it.startsWith("group;") && !results.contains(it) }.toSet()
        return results + groups.flatMap { findGroups(it, groups) }
    }
}