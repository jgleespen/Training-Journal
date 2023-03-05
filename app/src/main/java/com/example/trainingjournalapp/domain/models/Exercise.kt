package com.example.trainingjournalapp.domain.models

import java.util.*

interface Exercise {
    val name: String
    val parameters: List<UserExerciseParameter<Any>>
    val date: Date
}
