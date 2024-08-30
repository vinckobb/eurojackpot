package com.afterbitestudio.eurojackpot.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.afterbitestudio.eurojackpot.database.model.PopulatedUserDraw
import com.afterbitestudio.eurojackpot.database.model.UserDrawEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDrawDao {
    @Transaction
    @Query(value = "SELECT * FROM user_draws")
    fun getUserDrawEntities(): Flow<List<PopulatedUserDraw>?>;

    @Transaction
    @Query(value = """
        SELECT * FROM user_draws
        WHERE id = :id
    """)
    fun getUserDrawEntity(id: String): Flow<PopulatedUserDraw?>;

    @Transaction
    @Query(value = """
        SELECT * FROM user_draws
        where draw_id = :drawId
    """)
    fun getActiveUserDraw(drawId: String): Flow<PopulatedUserDraw?>;

    /**
     * Inserts [userDrawEntity] into the db if it doesn't exist, and ignores if do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnoreUserDraw(userDrawEntity: UserDrawEntity)
}