package com.example.Derrick.data.repository

interface AuthService {
    suspend fun login(email: String, password: String): Result<Boolean>
    suspend fun register(email: String, password: String): Result<Boolean>
    suspend fun sendPasswordResetEmail(email: String): Result<Boolean>
}
