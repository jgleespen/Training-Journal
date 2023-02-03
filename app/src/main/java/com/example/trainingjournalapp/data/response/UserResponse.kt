package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.User

data class UserResponse(
    override val email: String,
    override val username: String
) : User
