package com.afterbitestudio.eurojackpot.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.afterbitestudio.eurojackpot.database.model.PopulatedUserDraw
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDrawDao {
    @Transaction
    @Query(value = "SELECT * FROM user_draws")
    fun getUserDrawEntities(): Flow<List<PopulatedUserDraw>>;

    @Transaction
    @Query(value = """
        SELECT * FROM user_draws
        WHERE id = :id
    """)
    fun getUserDrawEntity(id: String): Flow<PopulatedUserDraw>;
}