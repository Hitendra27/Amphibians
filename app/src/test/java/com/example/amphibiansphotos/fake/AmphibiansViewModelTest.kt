package com.example.amphibiansphotos.fake

import com.example.amphibians.ui.screens.AmphibiansUiState
import com.example.amphibians.ui.screens.AmphibiansViewModel
import com.example.amphibiansphotos.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibiansPhotos_verifyAmphibiansUiStateSuccess() =
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                amphibiansRepository = FakeNetworkAmphibiansPhotosRepository()
            )
            assertEquals(
                AmphibiansUiState.Success(FakeDataSource.photosList),
                amphibiansViewModel.amphibiansUiState
            )
        }
}