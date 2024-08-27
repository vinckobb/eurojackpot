package com.afterbitestudio.eurojackpot

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel: ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = MutableStateFlow(MainActivityUiState.Success("Tomas"))
}

sealed interface MainActivityUiState {
    data object Loading: MainActivityUiState
    data class  Success(val user: String): MainActivityUiState
}