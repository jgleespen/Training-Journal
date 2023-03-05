package com.example.trainingjournalapp.domain.models

interface UserExerciseParameter<TypeOfParameter> {
    val name: String
    val value: TypeOfParameter
}
