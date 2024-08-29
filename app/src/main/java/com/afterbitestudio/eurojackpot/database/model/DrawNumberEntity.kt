package com.afterbitestudio.eurojackpot.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afterbitestudio.eurojackpot.model.DrawNumber

@Entity(
    tableName = "draw_numbers"
)
data class DrawNumberEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(
        name = "draw_entry_id"
    )
    val drawEntryId: String,
    @ColumnInfo(
        name = "draw_id"
    )
    val drawId: String,
    val number: Byte,
    @ColumnInfo(
        name = "euro_number"
    )
    val isEuroNumber: Boolean,
)

fun DrawNumberEntity.asExternalModel() = DrawNumber(
    id = id,
    number = number,
    isEuroNumber = isEuroNumber,
)