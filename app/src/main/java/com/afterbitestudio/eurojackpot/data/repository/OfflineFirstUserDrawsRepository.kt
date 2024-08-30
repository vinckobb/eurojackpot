package com.afterbitestudio.eurojackpot.data.repository

import com.afterbitestudio.eurojackpot.core.AppDispatchers
import com.afterbitestudio.eurojackpot.data.Synchronizer
import com.afterbitestudio.eurojackpot.database.dao.UserDrawDao
import com.afterbitestudio.eurojackpot.database.model.PopulatedUserDraw
import com.afterbitestudio.eurojackpot.database.model.asExternalModel
import com.afterbitestudio.eurojackpot.model.UserDraw
import com.afterbitestudio.eurojackpot.model.asEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class OfflineFirstUserDrawsRepository(
    private val userDrawDao: UserDrawDao,
    private val appDispatchers: AppDispatchers,
): UserDrawsRepository {
    override fun getUserDraws(): Flow<List<UserDraw>?> =
        userDrawDao.getUserDrawEntities()
            .map { it?.map(PopulatedUserDraw::asExternalModel) }

    override fun getUserDraw(id: String): Flow<UserDraw?> =
        userDrawDao.getUserDrawEntity(id)
            .map { it?.asExternalModel() }

    override fun getActiveUserDraw(drawId: String): Flow<UserDraw?> =
        userDrawDao.getActiveUserDraw(drawId)
            .map { it?.asExternalModel() }

    override suspend fun insertUserDraw(userDraw: UserDraw): Flow<UserDraw> {
        withContext(appDispatchers.IO) {
            userDrawDao.insertOrIgnoreUserDraw(userDraw.asEntity())
        }

        return flowOf(userDraw)
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        TODO("Not yet implemented")
    }
}