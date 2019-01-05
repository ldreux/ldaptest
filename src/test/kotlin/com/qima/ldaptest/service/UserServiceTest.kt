package com.qima.ldaptest.service

import com.qima.ldaptest.repository.LdapMockRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class UserServiceTest {
    @Test
    fun `getGroups with unknown user id`() {
        // Given
        val userService = UserService(LdapMockRepository())

        // When
        val groups = userService.getGroups("unknown_user_id")

        // Then
        assertThat(groups).isEmpty()
    }

    @Test
    fun `getGroups with user id 1`() {
        // Given
        val userService = UserService(LdapMockRepository())

        // When
        val groups = userService.getGroups("User_1")

        // Then
        assertThat(groups).isEqualTo(listOf("Group_1", "Group_2", "Group_3", "Group_4", "Group_5"))
    }
}