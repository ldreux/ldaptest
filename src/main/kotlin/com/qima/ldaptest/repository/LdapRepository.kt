package com.qima.ldaptest.repository

interface LdapRepository {
    fun exists(id: String): Boolean

    fun getGroups(id: String): List<String>
}