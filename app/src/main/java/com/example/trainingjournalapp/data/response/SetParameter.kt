package com.example.trainingjournalapp.data.response

import com.example.trainingjournalapp.domain.models.UserExerciseParameter


data class SetParam<T>(
    override val name: String,
    override val value: List<SetValue<T>>,
) : UserExerciseParameter<List<SetValue<T>>>


class SetValue<TypeOfSetValue>(
    val name: String,
    val value: List<TypeOfSetValue>
)

class Tuple<T>(
    private val elements: Array<T>
) {
    operator fun get(index: Int): T {
        when {
            index > 1 -> throw IndexOutOfBoundsException()
        }
        return elements[index]
    }
}