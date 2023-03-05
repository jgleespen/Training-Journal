package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.UserExerciseParameter

data class NumberListParameter(
    override val name: String,
    override var value: List<NumberParameter> = listOf(),
) : UserExerciseParameter<List<NumberParameter>>
