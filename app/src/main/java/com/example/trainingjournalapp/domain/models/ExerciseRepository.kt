package com.example.trainingjournalapp.domain.models

import com.example.trainingjournalapp.util.Response

interface ExerciseRepository {
    suspend fun getExerciseLog(): Response<List<Exercise>>

    suspend fun getWeekExerciseLog(): Response<List<Exercise>>

    suspend fun logExercise(): Response<Unit>
}