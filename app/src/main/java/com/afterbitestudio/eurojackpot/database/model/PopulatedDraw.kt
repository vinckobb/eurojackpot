package com.afterbitestudio.eurojackpot.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.afterbitestudio.eurojackpot.model.Draw

data class PopulatedDraw(
    @Embedded
    val entity: DrawEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "draw_id",
    )
    val drawnNumbers: List<DrawNumberEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "draw_id"
    )
    val results: List<DrawResultEntity>
)

fun PopulatedDraw.asExternalModel() = Draw(
    id = entity.id,
    isDrawn = entity.isDrawn,
    drawTime = entity.drawTime,
    betDeadline = entity.betDeadline,
    drawnNumbers = drawnNumbers.map(DrawNumberEntity::asExternalModel),
    results = results.map(DrawResultEntity::asExternalModel)
)