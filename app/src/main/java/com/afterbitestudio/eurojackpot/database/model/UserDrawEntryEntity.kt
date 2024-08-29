package com.afterbitestudio.eurojackpot.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afterbitestudio.eurojackpot.model.UserDrawEntry

@Entity(
    tableName = "user_draw_entries",
)
data class UserDrawEntryEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(
        name = "draw_id"
    )
    val drawId: String,
)

fun UserDrawEntryEntity.asExternalModel() = UserDrawEntry(
    id = id,
    numbers = listOf(),
    draw = null,
)