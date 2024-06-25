package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansData

interface AmphibiansRepository {
    /** Fetches a list of amphibians from the API */
    suspend fun getAmphibiansData(): List<AmphibiansData>
}

class NetworkAmphibiansRepository(
    private val AmphibiansService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<AmphibiansData> = AmphibiansService.getAmphibians()


}