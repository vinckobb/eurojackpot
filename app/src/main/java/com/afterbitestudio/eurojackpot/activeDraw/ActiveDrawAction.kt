package com.afterbitestudio.eurojackpot.activeDraw

sealed interface ActiveDrawAction {
    data object OnSomethingChange: ActiveDrawAction
}