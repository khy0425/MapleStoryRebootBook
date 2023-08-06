package com.example.rebootBook.dataClass

data class MidnightChaser(
    val smallResId: Int,
    val bigResId: Int,
    var state: State
) {
    enum class State {
        SELECTED, UNSELECTED, UNSELECTABLE
    }
}