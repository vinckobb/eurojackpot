package com.afterbitestudio.eurojackpot.model

import kotlinx.datetime.Instant


data class Draw(
    val id: String,
    val drawTime: Instant,
    val betDeadline: Instant,
    val isDrawn: Boolean,
    val results: List<DrawResult>,
    val drawnNumbers: List<DrawNumber>,
)