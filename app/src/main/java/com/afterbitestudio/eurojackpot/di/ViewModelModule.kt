package com.afterbitestudio.eurojackpot.di

import com.afterbitestudio.eurojackpot.activeDraw.ActiveDrawViewModel
import com.afterbitestudio.eurojackpot.drawHistory.DrawHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ActiveDrawViewModel)
    viewModelOf(::DrawHistoryViewModel)
}