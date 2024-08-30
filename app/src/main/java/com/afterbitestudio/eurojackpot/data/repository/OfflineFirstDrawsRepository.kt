package com.afterbitestudio.eurojackpot.data.repository

import com.afterbitestudio.eurojackpot.data.Synchronizer
import com.afterbitestudio.eurojackpot.database.dao.DrawDao
import com.afterbitestudio.eurojackpot.database.model.asExternalModel
import com.afterbitestudio.eurojackpot.model.Draw
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class OfflineFirstDrawsRepository(
    private val drawDao: DrawDao
): DrawsRepository {
    override fun getActiveDraw(): Flow<Draw?> =
        drawDao.getActiveDraw()
        .map { it?.asExternalModel() }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        TODO("Not yet implemented")
    }
}