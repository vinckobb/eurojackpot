package com.afterbitestudio.eurojackpot.model

import com.afterbitestudio.eurojackpot.database.model.UserDrawEntity
import kotlinx.datetime.Instant


data class UserDraw(
    val id: String,
    val createdAt: Instant,
    val entries: List<UserDrawEntry>? = null,
    val draw: Draw? = null,
)

fun UserDraw.asEntity() = UserDrawEntity(
    id = id,
    createdAt = createdAt,
    drawId = draw?.id
)