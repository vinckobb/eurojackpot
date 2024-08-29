package com.afterbitestudio.eurojackpot.model

data class DrawNumber(
    val id: String,
    val number: Byte,
    val isEuroNumber: Boolean,
    val draw: Draw? = null,
    val userDrawEntry: UserDrawEntry? = null,
)