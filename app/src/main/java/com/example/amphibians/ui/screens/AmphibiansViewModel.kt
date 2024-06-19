package com.example.amphibians.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch

sealed interface AmphibiansUiState {
    data class Success(val photos: String) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}

class AmphibiansViewModel : ViewModel() {
    //** The mutable State stores the status of the most recent request */
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
    private set

    /**
     * Call getAmphibianList() on init so we can display status immediately.
     */
    init {
        getAmphibianList()
    }

    /**
     * Gets Amphibian information from the Amphibians API Retrofit service and updates the
     * [AmphibiansPhotas] [List] [MutableList].
     */

    private fun getAmphibianList() {
        viewModelScope.launch {
           amphibiansUiState = try {
                val listResult = AmphibiansApi.retrofitService.getAmphibians()
                AmphibiansUiState.Success(listResult)
            } catch (e: Exception) {
                AmphibiansUiState.Error
            }
        }
    }
}