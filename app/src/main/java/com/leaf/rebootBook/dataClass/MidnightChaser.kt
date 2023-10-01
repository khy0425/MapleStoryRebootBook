package com.leaf.rebootBook.dataClass

data class MidnightChaser(
    val smallResId: Int,
    val bigResId: Int,
    var state: State,
) {
    enum class State {
        UNSELECTED, SELECTED, UNAVAILABLE, UNSELECTABLE
    }
}