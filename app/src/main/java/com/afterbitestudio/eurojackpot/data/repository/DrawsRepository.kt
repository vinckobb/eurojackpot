package com.afterbitestudio.eurojackpot.data.repository

import com.afterbitestudio.eurojackpot.data.Syncable
import com.afterbitestudio.eurojackpot.model.Draw
import kotlinx.coroutines.flow.Flow

interface DrawsRepository: Syncable {
    fun getActiveDraw(): Flow<Draw?>
}