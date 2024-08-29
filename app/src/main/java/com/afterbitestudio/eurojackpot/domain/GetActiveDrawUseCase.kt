package com.afterbitestudio.eurojackpot.domain

import com.afterbitestudio.eurojackpot.data.repository.UserDrawsRepository
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.flow.Flow

class GetActiveDrawUseCase(
    private val userDrawsRepository: UserDrawsRepository,
) {
    operator fun invoke(): Flow<List<UserDraw>> = userDrawsRepository.getUserDraws()
}