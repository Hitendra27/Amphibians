package com.example.amphibians.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch

class AmphibiansViewModel : ViewModel() {
    //** The mutable State stores the status of the most recent request */
    var amphibiansUiState: String by mutableStateOf("")
    private set

    /**
     * Call getAmphibianList() on init so we can display status immediately.
     */
    init {
        getAmphibianList()
    }

    /**
     * Gets Amphibian information from the Amphibians API Retrofit service and updates the
     * [AmphibiansPhoto] [List] [MutableList].
     */

    private fun getAmphibianList() {
        viewModelScope.launch {
            val listResult = AmphibiansApi.retrofitService.getAmphibians()
            amphibiansUiState = listResult
        }
    }
}