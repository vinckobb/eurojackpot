package com.afterbitestudio.eurojackpot.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.afterbitestudio.eurojackpot.model.UserDrawEntry

data class PopulatedUserDrawEntry(
    @Embedded
    val entity: UserDrawEntryEntity,
    @Relation(
        parentColumn = "draw_id",
        entityColumn = "id",
        entity = DrawEntity::class
    )
    val draw: PopulatedDraw,
    @Relation(
        parentColumn = "id",
        entityColumn = "draw_entry_id",
    )
    val numbers: List<DrawNumberEntity>,
)

fun PopulatedUserDrawEntry.asExternalModel() = UserDrawEntry(
    id = entity.id,
    draw = draw.asExternalModel(),
    numbers = numbers.map(DrawNumberEntity::asExternalModel)
)