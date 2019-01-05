package com.qima.ldaptest.repository

import org.springframework.stereotype.Repository

@Repository
class LdapMockRepository : LdapRepository {
    private val users = mapOf(
            "user;User_1" to listOf("user;User_1", "group;Group_1", "group;Group_2", "group;Group_3", "user;User_2", "group;Group_5"),
            "user;User_2" to listOf("user;User_2", "group;Group_2"),
            "user;User_3" to listOf("user;User_2", "group;Group_72"),
            "group;Group_1" to listOf("user;User_1", "group;Group_2"),
            "group;Group_2" to listOf("user;User_2", "group;Group_4"),
            "group;Group_3" to listOf(),
            "group;Group_4" to listOf(),
            "group;Group_5" to listOf("user;User_2")
    )

    override fun exists(id: String) = users.containsKey(id)

    override fun getGroups(id: String) = users[id] ?: emptyList()
}