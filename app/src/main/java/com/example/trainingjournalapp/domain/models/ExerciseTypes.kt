package com.example.trainingjournalapp.domain.models


sealed interface Exercise {
    val name: String
    val parameters: List<ExerciseParameter<Any>>
}

sealed interface ExerciseParameter<TypeOfParameter> {
    val name: String
    val value: TypeOfParameter
}


data class NumberParameter(
    override val name: String,
    override var value: Double = 0.0,
) : ExerciseParameter<Double>

data class StringParameter(
    override val name: String,
    override var value: String = String(),
) : ExerciseParameter<String>

data class OptionParameter(
    override val name: String,
    override val value: Boolean = false
) : ExerciseParameter<Boolean>

data class NumberListParameter(
    override val name: String,
    override var value: List<Double> = listOf(),
) : ExerciseParameter<List<Double>>

data class StringListParameter(
    override val name: String,
    override var value: List<String> = listOf()
) : ExerciseParameter<List<String>>
