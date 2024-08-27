package com.afterbitestudio.eurojackpot.drawHistory

sealed interface DrawHistoryAction {
    data object OnDrawClick: DrawHistoryAction
}