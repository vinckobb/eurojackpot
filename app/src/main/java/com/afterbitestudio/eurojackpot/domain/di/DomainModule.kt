package com.afterbitestudio.eurojackpot.domain.di

import com.afterbitestudio.eurojackpot.domain.GetOrCreateActiveUserDrawUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetOrCreateActiveUserDrawUseCase> {
        GetOrCreateActiveUserDrawUseCase(
            userDrawsRepository = get(),
            drawsRepository = get(),
        )
    }
}