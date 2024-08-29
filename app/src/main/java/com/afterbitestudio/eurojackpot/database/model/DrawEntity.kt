package com.afterbitestudio.eurojackpot.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afterbitestudio.eurojackpot.model.Draw
import kotlinx.datetime.Instant

@Entity(
    tableName = "draws",
)
data class DrawEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(
        name = "draw_time",
    )
    val drawTime: Instant,
    @ColumnInfo(
        name = "bet_deadline",
    )
    val betDeadline: Instant,
    @ColumnInfo(
        name = "drawn"
    )
    val isDrawn: Boolean,
)

fun DrawEntity.asExternalModel() = Draw(
    id = id,
    drawTime = drawTime,
    betDeadline = betDeadline,
    isDrawn = isDrawn,
    results = listOf(),
    drawnNumbers = listOf(),
)