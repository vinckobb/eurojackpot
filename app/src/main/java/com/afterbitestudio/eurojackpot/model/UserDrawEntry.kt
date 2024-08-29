package com.afterbitestudio.eurojackpot.model

data class UserDrawEntry(
    val id: String,
    val numbers: List<DrawNumber>,
    val draw: Draw?,
)