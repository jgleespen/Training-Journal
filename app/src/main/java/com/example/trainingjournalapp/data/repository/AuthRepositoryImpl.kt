package com.example.trainingjournalapp.data.repository

import com.example.trainingjournalapp.data.response.UserResponse
import com.example.trainingjournalapp.domain.models.AuthRepository
import com.example.trainingjournalapp.domain.models.DummyUser
import com.example.trainingjournalapp.domain.models.User
import com.example.trainingjournalapp.util.Response
import com.example.trainingjournalapp.util.Response.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : AuthRepository {


    /** Dummy implementation **/
    override suspend fun getCurrentUser(): Response<User> = Response.Success(DummyUser(email = "bruh@gmail.com", "Bruh"))

    override suspend fun getCurrentUserId(): Response<String> {
        TODO("Not yet implemented")
    }

    override suspend fun registerUserWithUsername(
        email: String,
        password: String,
        username: String
    ): Response<User> {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): Response<User> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordResetEmail(email: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateEmail(newEmail: String, password: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePassword(oldPassword: String, newPassword: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUsername(username: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}
