package com.afterbitestudio.eurojackpot.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.afterbitestudio.eurojackpot.model.UserDraw

data class PopulatedUserDraw(
    @Embedded
    val entity: UserDrawEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "draw_id",
        entity = UserDrawEntity::class
    )
    val entries: List<PopulatedUserDrawEntry>,
    @Relation(
        parentColumn = "draw_id",
        entityColumn = "id",
        entity = DrawEntity::class
    )
    val draw: PopulatedDraw,
)

fun PopulatedUserDraw.asExternalModel() = UserDraw(
    id = entity.id,
    createdAt = entity.createdAt,
    draw = draw.asExternalModel(),
    entries = entries.map(PopulatedUserDrawEntry::asExternalModel)
)