package com.afterbitestudio.eurojackpot

import android.app.Application
import com.afterbitestudio.eurojackpot.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EurojackpotApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EurojackpotApplication)
            modules(appModule)
        }
    }
}