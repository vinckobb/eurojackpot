package com.afterbitestudio.eurojackpot.activeDraw

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afterbitestudio.eurojackpot.domain.GetActiveDrawUseCase
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ActiveDrawViewModel(
    getActiveDraw: GetActiveDrawUseCase
): ViewModel() {

    val uiState: StateFlow<ActiveDrawUiState> = getActiveDraw().map {
        ActiveDrawUiState.ActiveDraw(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ActiveDrawUiState.Loading
    )

    fun onAction(action: ActiveDrawAction) {
        when(action) {
            ActiveDrawAction.OnSomethingChange -> {

            }
        }
    }
}

sealed interface ActiveDrawUiState {
    data object Loading: ActiveDrawUiState

    data class ActiveDraw(
        val draws: List<UserDraw>
    ): ActiveDrawUiState

    data object Empty: ActiveDrawUiState
}