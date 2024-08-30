package com.afterbitestudio.eurojackpot.di

import com.afterbitestudio.eurojackpot.core.AppDispatchers
import com.afterbitestudio.eurojackpot.core.dispatcher.AppDispatchersImpl
import org.koin.dsl.module

val applicationModule = module {
    single<AppDispatchers> {
        AppDispatchersImpl()
    }
}