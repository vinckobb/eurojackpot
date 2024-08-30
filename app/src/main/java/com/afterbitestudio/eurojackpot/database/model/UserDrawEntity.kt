package com.afterbitestudio.eurojackpot.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.datetime.Instant

@Entity(
    tableName = "user_draws",
)
data class UserDrawEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(
        name = "draw_id"
    )
    val drawId: String?,
    @ColumnInfo(
        name = "created_at"
    )
    val createdAt: Instant,
)

fun UserDrawEntity.asExternalModel() = UserDraw(
    id = id,
    createdAt = createdAt,
    entries = listOf(),
)