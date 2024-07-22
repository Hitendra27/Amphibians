package com.example.amphibiansphotos.fake

import com.example.amphibians.ui.screens.AmphibiansUiState
import com.example.amphibians.ui.screens.AmphibiansViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AmphibiansViewModelTest {

    @Test
    fun amphibiansViewModel_getAmphibiansPhotos_verifyAmphibiansUiStateSuccess() =
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                amphibiansRepository = FakeNetworkAmphibiansPhotosRepository()
            )
            assertEquals(
                AmphibiansUiState.Success("Success : ${FakeDataSource.photosList.size} Amphibians " +
                "photos retrieved"),
                amphibiansViewModel.amphibiansUiState
            )
        }
}