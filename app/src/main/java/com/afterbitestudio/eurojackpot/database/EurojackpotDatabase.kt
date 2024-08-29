package com.afterbitestudio.eurojackpot.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.afterbitestudio.eurojackpot.database.dao.UserDrawDao
import com.afterbitestudio.eurojackpot.database.model.DrawEntity
import com.afterbitestudio.eurojackpot.database.model.DrawNumberEntity
import com.afterbitestudio.eurojackpot.database.model.DrawResultEntity
import com.afterbitestudio.eurojackpot.database.model.UserDrawEntity
import com.afterbitestudio.eurojackpot.database.model.UserDrawEntryEntity
import com.afterbitestudio.eurojackpot.database.util.InstantConverter

@Database(
    entities = [
        DrawEntity::class,
        DrawNumberEntity::class,
        DrawResultEntity::class,
        UserDrawEntity::class,
        UserDrawEntryEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class EurojackpotDatabase: RoomDatabase() {
    abstract fun userDrawDao(): UserDrawDao
}