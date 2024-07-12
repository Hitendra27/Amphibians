package com.example.amphibiansphotos.fake

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansData

class FakeAmphibiansApiService : AmphibiansApiService {
    override suspend fun getAmphibians(): List<AmphibiansData> {
        return FakeDataSource.photosList
    }
}