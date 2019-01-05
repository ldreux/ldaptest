package com.qima.ldaptest.controller

import com.qima.ldaptest.LdapTestApplication
import io.restassured.RestAssured
import io.restassured.RestAssured.`when`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(classes = [LdapTestApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
class UserControllerIntegrationTest {
    @Value("\${local.server.port}")
    var port: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
    }

    @Test
    fun findUser() {
        `when`()
                .get("/users/User_1")
        .then()
                .statusCode(200)
                .body("userId", equalTo("User_1"))
                .body("groups", equalTo(listOf("Group_1", "Group_2", "Group_3", "Group_4", "Group_5")))
    }

    @Test
    fun `find unknown user`() {
        `when`()
                .get("/users/unknown_user")
        .then()
                .statusCode(404)
                .body("message", equalTo("User unknown_user is not found"))
    }
}