package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.Exercise
import com.example.trainingjournalapp.domain.models.UserExerciseParameter
import java.util.*

data class ExerciseImpl(
    override val name: String,
    override val parameters: List<UserExerciseParameter<Any>>,
    override val date: Date
) : Exercise
