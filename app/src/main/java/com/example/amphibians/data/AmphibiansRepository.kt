package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApi
import com.example.amphibians.network.AmphibiansData

interface AmphibiansRepository {
    /** Fetches a list of amphibians from the API */
    suspend fun getAmphibiansData(): List<AmphibiansData>
}

class NetworkAmphibiansRepository() : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<AmphibiansData> {
        return AmphibiansApi.retrofitService.getAmphibians()
    }


}