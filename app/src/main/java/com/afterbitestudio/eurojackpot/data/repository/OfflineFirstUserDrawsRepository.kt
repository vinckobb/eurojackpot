package com.afterbitestudio.eurojackpot.data.repository

import com.afterbitestudio.eurojackpot.data.Synchronizer
import com.afterbitestudio.eurojackpot.database.dao.UserDrawDao
import com.afterbitestudio.eurojackpot.database.model.PopulatedUserDraw
import com.afterbitestudio.eurojackpot.database.model.asExternalModel
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class OfflineFirstUserDrawsRepository(
    private val userDrawDao: UserDrawDao,
): UserDrawsRepository {
    override fun getUserDraws(): Flow<List<UserDraw>> =
        userDrawDao.getUserDrawEntities()
            .map { it.map(PopulatedUserDraw::asExternalModel) }

    override fun getUserDraw(id: String): Flow<UserDraw> =
        userDrawDao.getUserDrawEntity(id)
            .map { it.asExternalModel() }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        TODO("Not yet implemented")
    }
}