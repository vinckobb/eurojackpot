package com.afterbitestudio.eurojackpot.model

import kotlinx.datetime.Instant


data class UserDraw(
    val id: String,
    val createdAt: Instant,
    val entries: List<UserDrawEntry>,
    val draw: Draw? = null,
)