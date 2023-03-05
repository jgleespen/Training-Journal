package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.UserExerciseParameter

data class NumberParameter(
    override val name: String,
    override var value: Float = 0f,
) : UserExerciseParameter<Float>
