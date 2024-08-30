package com.afterbitestudio.eurojackpot

import android.app.Application
import com.afterbitestudio.eurojackpot.data.di.resositoryModule
import com.afterbitestudio.eurojackpot.database.di.databaseModule
import com.afterbitestudio.eurojackpot.di.viewModelModule
import com.afterbitestudio.eurojackpot.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EurojackpotApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EurojackpotApplication)
            modules(
                resositoryModule,
                viewModelModule,
                domainModule,
                databaseModule,
            )
        }
    }
}