package com.afterbitestudio.eurojackpot.domain.di

import com.afterbitestudio.eurojackpot.domain.GetActiveDrawUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetActiveDrawUseCase> {
        GetActiveDrawUseCase(
            userDrawsRepository = get()
        )
    }
}