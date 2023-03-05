package com.example.trainingjournalapp.data.repository

import com.example.trainingjournalapp.data.response.*
import com.example.trainingjournalapp.domain.models.Exercise
import com.example.trainingjournalapp.domain.models.ExerciseRepository
import com.example.trainingjournalapp.util.Response.*
import com.example.trainingjournalapp.util.Response
import com.google.firebase.firestore.FirebaseFirestore
import java.util.concurrent.CancellationException
import javax.inject.Inject

class ExerciseRepositoryImpl
@Inject
private constructor(private val db: FirebaseFirestore) : ExerciseRepository {

    override suspend fun getExerciseLog(): Response<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeekExerciseLog(): Response<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override suspend fun logExercise(): Response<Unit> {
        try {
            var setVal1 = SetValue(name = "RPE", value = listOf(8f, "ok"))
            var setVal2 = SetValue(name =)

            var setParameter = SetParameter()

            db.collection("exercises")
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> return Error(Unit)
            }
        }
    }
}