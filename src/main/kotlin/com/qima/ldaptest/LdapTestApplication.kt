package com.qima.ldaptest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LdapTestApplication

fun main(args: Array<String>) {
    SpringApplication.run(LdapTestApplication::class.java, *args)
}
