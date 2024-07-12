package com.example.amphibiansphotos.fake

import com.example.amphibians.data.NetworkAmphibiansRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkAmphibiansRepositoryTest {
    @Test
    fun networkAmphibiansRepository_getAmphibiansPhotos_verifyPhotoList() =
        runTest {
            val repository = NetworkAmphibiansRepository(
                AmphibiansService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.photosList, repository.getAmphibiansData())
        }
}
