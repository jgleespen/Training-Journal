package com.example.trainingjournalapp.data.repository

import com.example.trainingjournalapp.data.response.UserResponse
import com.example.trainingjournalapp.domain.models.AuthRepository
import com.example.trainingjournalapp.domain.models.DummyUser
import com.example.trainingjournalapp.domain.models.User
import com.example.trainingjournalapp.util.Response
import com.example.trainingjournalapp.util.Response.*
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException
import javax.inject.Inject


class AuthRepositoryImpl
@Inject
constructor(private val auth: FirebaseAuth) : AuthRepository {
    override suspend fun getCurrentUser(): Response<User> {
        return try {
            Success(auth.currentUser!!.run {
                UserResponse(
                    email = this.email ?: "Error: Missing email",
                    username = displayName ?: "Error: Missing username"
                )
            })
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> Error(exception = e)
            }
        }
    }


    override suspend fun getCurrentUserUid(): Response<String> {
        return try {
            Success(auth.currentUser!!.run {
                this.uid
            })
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> Error(exception = e)
            }
        }
    }

    override suspend fun registerUserWithUsername(
        email: String,
        password: String,
        username: String
    ): Response<User> {
        return try {
            auth.createUserWithEmailAndPassword(email, password)
                .await().user!!.let { registeredUser ->
                    registeredUser.updateProfile(
                        UserProfileChangeRequest.Builder().setDisplayName(username).build()
                    ).await()
                    Success(
                        UserResponse(
                            email = email,
                            username = username
                        )
                    )
                }
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> Error(exception = e)
            }
        }
    }

    override suspend fun login(
        email: String,
        password: String
    ): Response<User> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await().user!!.run {
                Success(
                    UserResponse(
                        email = email,
                        username = displayName ?: "Error: Missing username"
                    )
                )
            }
        } catch (e: Exception) {
            when(e) {
                is CancellationException -> throw e
                else -> Error(exception = e)
            }
        }
    }

    override suspend fun logout(): Response<Unit> {
        return try {
            auth.signOut()
            Success(Unit)
        } catch (e: java.lang.Exception) {
            when(e) {
                is CancellationException -> throw e
                else -> Error(exception = e)
            }
        }
    }


    override suspend fun updateEmail(newEmail: String, password: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordResetEmail(email: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePassword(
        oldPassword: String,
        newPassword: String
    ): Response<Unit> {
        return try {
            auth.currentUser!!.run {
                reauthenticate(
                    EmailAuthProvider.getCredential(email!!, oldPassword)
                ).await()
                updatePassword(newPassword).await()
                Success(Unit)
            }
        } catch(e: Exception) {
            when(e) {
                is CancellationException -> throw e
                else -> {
                    Error(exception = e)
                }
            }
        }
    }

    override suspend fun updateUsername(username: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}
