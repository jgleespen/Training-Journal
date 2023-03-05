package com.example.trainingjournalapp.data.repository

import com.example.trainingjournalapp.domain.models.Exercise
import com.example.trainingjournalapp.domain.models.ExerciseRepository
import com.example.trainingjournalapp.util.Response
import com.example.trainingjournalapp.util.Response.*

class ExerciseRepositoryDummyImpl : ExerciseRepository {
    override suspend fun getExerciseLog(): Response<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeekExerciseLog(): Response<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override suspend fun logExercise(): Response<Unit> {
        val exercise = Exercise()
        return Success(listOf(Exercise))
    }
}