package com.afterbitestudio.eurojackpot.activeDraw

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afterbitestudio.eurojackpot.domain.GetOrCreateActiveUserDrawUseCase
import com.afterbitestudio.eurojackpot.model.UserDraw
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ActiveDrawViewModel(
    getOrCreateActiveUserDraw: GetOrCreateActiveUserDrawUseCase
): ViewModel() {

    //TODO handle if active user draw is null/thrown error? Return uistate empty
    val uiState: StateFlow<ActiveDrawUiState> = getOrCreateActiveUserDraw().map {
        it?.let {
            userDraw -> return@map ActiveDrawUiState.ActiveDraw(userDraw)
        }

        ActiveDrawUiState.Empty
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
        val activeUserDraw: UserDraw
    ): ActiveDrawUiState

    data object Empty: ActiveDrawUiState
}