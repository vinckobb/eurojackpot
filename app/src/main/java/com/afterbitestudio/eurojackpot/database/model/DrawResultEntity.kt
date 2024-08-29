package com.afterbitestudio.eurojackpot.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afterbitestudio.eurojackpot.model.DrawResult

@Entity(
    tableName = "draw_results"
)
data class DrawResultEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(
        name = "draw_id"
    )
    val drawId: String,
    val combination: Byte,
    val winnings: Float
)

fun DrawResultEntity.asExternalModel() = DrawResult(
    id = id,
    combination = combination,
    winnings = winnings,
)