package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.UserExerciseParameter

data class StringListParameter(
    override val name: String,
    override var value: List<String> = listOf()
) : UserExerciseParameter<List<String>>
