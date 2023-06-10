package com.example.maeassignment

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    // Get the current user from the database

    // Login function
    suspend fun login(email: String, password: String): AuthResult {
        val user = userDao.getUserByEmail(email)
        return if (user != null && user.password == password) {
            AuthResult.SUCCESS
        } else {
            AuthResult.INVALID_CREDENTIALS
        }
    }

    // Register function
    suspend fun register(user: User): AuthResult {
        val existingUser = userDao.getUserByEmail(user.email)
        return if (existingUser != null) {
            AuthResult.EMAIL_ALREADY_EXISTS
        } else {
            userDao.insertUser(user)
            AuthResult.SUCCESS
        }
    }
}

