package com.example.trainingjournalapp.domain.usecases.authentication;

import com.example.trainingjournalapp.domain.models.AuthRepository
import com.example.trainingjournalapp.domain.models.User
import com.example.trainingjournalapp.util.Response
import javax.inject.Inject;

class GetUserUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): Response<User> {
        return authRepository.getCurrentUser()
    }
}
