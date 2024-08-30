package com.afterbitestudio.eurojackpot.domain

import com.afterbitestudio.eurojackpot.data.repository.DrawsRepository
import com.afterbitestudio.eurojackpot.data.repository.UserDrawsRepository
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEmpty
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import java.util.UUID

class GetOrCreateActiveUserDrawUseCase(
    private val userDrawsRepository: UserDrawsRepository,
    private val drawsRepository: DrawsRepository,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<UserDraw?> {
        /**
         * 1. Get active draw -> lowest draw date and drawn = false. If null then return null?
         * 2. Get user draw that is referencing active draw. If not found then create new one
         * 3. Return active user draw
         */
        return drawsRepository.getActiveDraw()
            .flatMapLatest activeDrawResult@ { activeDraw ->
                if (activeDraw == null) {
                    return@activeDrawResult flowOf(null)
                }

                userDrawsRepository.getActiveUserDraw(activeDraw.id)
                    .flatMapLatest activeUserDrawResult@{ userDraw ->
                        if (userDraw == null) {
                            val newUserDraw = UserDraw(
                                id = UUID.randomUUID().toString(),
                                createdAt = Clock.System.now(),
                                draw = activeDraw,
                            )

                            return@activeUserDrawResult userDrawsRepository
                                .insertUserDraw(newUserDraw)
                                .flatMapLatest { _ ->
                                    return@flatMapLatest flowOf(newUserDraw)
                                }
                        }

                        flowOf(userDraw)
                    }
            }
    }
}