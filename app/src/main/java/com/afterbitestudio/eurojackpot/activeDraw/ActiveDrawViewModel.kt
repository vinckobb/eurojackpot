package com.afterbitestudio.eurojackpot.activeDraw

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ActiveDrawViewModel: ViewModel() {

    var state by mutableStateOf(ActiveDrawState())
        private set

    fun onAction(action: ActiveDrawAction) {
        when(action) {
            ActiveDrawAction.OnSomethingChange -> {

            }
        }
    }
}