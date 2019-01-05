package com.qima.ldaptest.model

data class User(val userId: String,
                val groups: List<String>)