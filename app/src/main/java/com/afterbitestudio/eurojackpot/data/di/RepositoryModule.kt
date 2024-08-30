package com.afterbitestudio.eurojackpot.data.di

import com.afterbitestudio.eurojackpot.data.repository.DrawsRepository
import com.afterbitestudio.eurojackpot.data.repository.OfflineFirstDrawsRepository
import com.afterbitestudio.eurojackpot.data.repository.OfflineFirstUserDrawsRepository
import com.afterbitestudio.eurojackpot.data.repository.UserDrawsRepository
import org.koin.dsl.module

val resositoryModule = module {
    single<UserDrawsRepository> {
        OfflineFirstUserDrawsRepository(
            userDrawDao = get(),
            appDispatchers = get(),
        )
    }

    single<DrawsRepository> {
        OfflineFirstDrawsRepository(
            drawDao = get()
        )
    }
}