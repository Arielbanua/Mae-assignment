package com.example.maeassignment

import java.util.*

data class Expense(
    val id: Long,
    val amount: Double,
    val category: String,
    val date: Date,
    // Other properties as needed
)

data class Budget(
    val id: Long,
    val amount: Double,
    val category: String,
    // Other properties as needed
)

data class User(
    val email: String,
    val username: String,
    val password: String
    // Other user properties as needed
)
