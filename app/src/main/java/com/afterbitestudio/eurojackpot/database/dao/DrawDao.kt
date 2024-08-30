package com.afterbitestudio.eurojackpot.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.afterbitestudio.eurojackpot.database.model.PopulatedDraw
import kotlinx.coroutines.flow.Flow

@Dao
interface DrawDao {
    @Transaction
    @Query(value = """
        SELECT * FROM draws
        WHERE drawn = 0
        ORDER BY draw_time ASC
    """
    )
    fun getActiveDraw(): Flow<PopulatedDraw?>;
}