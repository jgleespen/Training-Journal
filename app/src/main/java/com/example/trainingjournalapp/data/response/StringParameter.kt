package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.UserExerciseParameter

data class StringParameter(
    override val name: String,
    override var value: String = String(),
) : UserExerciseParameter<String>
