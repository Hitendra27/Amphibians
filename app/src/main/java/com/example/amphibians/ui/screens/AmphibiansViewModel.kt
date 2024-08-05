package com.example.amphibians.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.data.NetworkAmphibiansRepository
import com.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch

sealed interface AmphibiansUiState {
    data class Success(val photos: String) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}

class AmphibiansViewModel(
    private val amphibiansRepository: AmphibiansRepository
) : ViewModel() {
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
                val result = amphibiansRepository.getAmphibiansData()[0]
                AmphibiansUiState.Success(
                    "First Amphibian image URL: ${result.imgSrc}"
                )
            } catch (e: Exception) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
        }
        }
    }
}