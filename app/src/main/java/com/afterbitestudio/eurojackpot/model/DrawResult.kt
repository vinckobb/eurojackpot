package com.afterbitestudio.eurojackpot.model

data class DrawResult(
    val id: String,
    val combination: Byte, //TODO change to enum?
    val winnings: Float,
    val draw: Draw? = null,
)