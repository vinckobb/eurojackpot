package com.afterbitestudio.eurojackpot.drawHistory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DrawHistoryViewModel: ViewModel() {
    var state by mutableStateOf(DrawHistoryState(
        something = "Test"
    ))
        private set

    fun onAction(action: DrawHistoryAction) {
        when(action) {
            DrawHistoryAction.OnDrawClick -> {

            }
        }
    }
}