package com.example.trainingjournalapp.domain.usecases.exerciselogging

import com.example.trainingjournalapp.data.repository.ExerciseRepositoryDummyImpl
import com.example.trainingjournalapp.util.Response
import javax.inject.Inject

class LogExerciseUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepositoryDummyImpl
) {
    suspend operator fun invoke(): Response<Unit> {
        return exerciseRepository.logExercise()
    }
}