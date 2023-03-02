package com.example.trainingjournalapp.domain.models

import com.example.trainingjournalapp.domain.models.ExerciseParameterType.*

sealed interface MutableExercise {
    val name: String
    val parameters: List<ExerciseParameter<out Any>>
}

enum class ExerciseParameterType {
    NUMBER,
    TEXT,
    OPTION,
    NUMBER_LIST,
    STRING_LIST,
}

sealed interface ExerciseParameter<T> {
    val name: String
    val type: ExerciseParameterType
    val value: T
    fun updateValue(value: T)

    data class NumberParameter(
        override val name: String,
        override val type: ExerciseParameterType = NUMBER,
        override var value: Double,
    ) : ExerciseParameter<Double> {
        override fun updateValue(value: Double) {
            TODO("Not yet implemented")
        }
    }

    data class StringParameter(
        override val name: String,
        override val type: ExerciseParameterType = TEXT,
        override var value: String?,
    ) : ExerciseParameter<String?> {

        override fun updateValue(value: String?) {
            TODO("Not yet implemented")
        }
    }

    data class OptionParameter(
        override val name: String,
        override val type: ExerciseParameterType = OPTION,
        override val value: Boolean
    ) : ExerciseParameter<Boolean> {
        override fun updateValue(value: Boolean) {
            TODO("Not yet implemented")
        }
    }

    data class NumberListParameter(
        override val name: String,
        override val type: ExerciseParameterType = NUMBER_LIST,
        override var value: List<Double>,
    ) : ExerciseParameter<List<Double>> {
        override fun updateValue(value: List<Double>) {
            this.value = this.value + value
        }
    }

    data class StringListParameter(
        override val name: String,
        override val type: ExerciseParameterType = STRING_LIST,
        override var value: List<String> = listOf()
    ) : ExerciseParameter<List<String>> {
        override fun updateValue(value: List<String>) {
            this.value = this.value + value
        }
    }
}
