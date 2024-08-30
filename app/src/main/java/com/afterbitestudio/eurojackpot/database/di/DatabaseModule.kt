package com.afterbitestudio.eurojackpot.database.di

import androidx.room.Room
import com.afterbitestudio.eurojackpot.database.EurojackpotDatabase
import com.afterbitestudio.eurojackpot.database.dao.UserDrawDao
import org.koin.core.scope.Scope
import org.koin.dsl.module

private const val DATABASE_NAME = "eurojackpot.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), EurojackpotDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single<UserDrawDao> {
        getDatabase().userDrawDao()
    }
}

private fun Scope.getDatabase(): EurojackpotDatabase {
    return this.get()
}