package com.example.amphibiansphotos.fake

import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.network.AmphibiansData

class FakeNetworkAmphibiansPhotosRepository : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<AmphibiansData> {
        return FakeDataSource.photosList
    }
}