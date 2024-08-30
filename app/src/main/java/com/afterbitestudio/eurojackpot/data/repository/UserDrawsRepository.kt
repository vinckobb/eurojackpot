package com.afterbitestudio.eurojackpot.data.repository

import com.afterbitestudio.eurojackpot.data.Syncable
import com.afterbitestudio.eurojackpot.database.model.UserDrawEntity
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.flow.Flow

interface UserDrawsRepository : Syncable {
    fun getUserDraws(): Flow<List<UserDraw>?>

    fun getUserDraw(id: String): Flow<UserDraw?>

    fun getActiveUserDraw(drawId: String): Flow<UserDraw?>

    suspend fun insertUserDraw(userDraw: UserDraw): Flow<UserDraw>
}