package com.afterbitestudio.eurojackpot.di

import androidx.room.Room
import com.afterbitestudio.eurojackpot.activeDraw.ActiveDrawViewModel
import com.afterbitestudio.eurojackpot.data.repository.OfflineFirstUserDrawsRepository
import com.afterbitestudio.eurojackpot.data.repository.UserDrawsRepository
import com.afterbitestudio.eurojackpot.database.EurojackpotDatabase
import com.afterbitestudio.eurojackpot.database.dao.UserDrawDao
import com.afterbitestudio.eurojackpot.domain.GetActiveDrawUseCase
import com.afterbitestudio.eurojackpot.drawHistory.DrawHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

private const val DATABASE_NAME = "eurojackpot.db"

val appModule = module {
    viewModelOf(::ActiveDrawViewModel)
    viewModelOf(::DrawHistoryViewModel)

    single {
        Room.databaseBuilder(get(), EurojackpotDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single<UserDrawDao> {
        getDatabase().userDrawDao()
    }

    single<UserDrawsRepository> {
        OfflineFirstUserDrawsRepository(
            userDrawDao = get()
        )
    }

    single<GetActiveDrawUseCase> {
        GetActiveDrawUseCase(
            userDrawsRepository = get()
        )
    }
}

private fun Scope.getDatabase(): EurojackpotDatabase {
    return this.get()
}