package com.afterbitestudio.eurojackpot

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
//    val uiState: StateFlow<MainActivityUiState> =
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: String) : MainActivityUiState
}