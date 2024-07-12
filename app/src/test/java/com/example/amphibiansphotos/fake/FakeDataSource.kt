package com.example.amphibiansphotos.fake

import com.example.amphibians.network.AmphibiansData

object FakeDataSource {

    const val nameOne = "img1"
    const val nameTwo = "img2"
    const val typeOne = "type1"
    const val typeTwo = "type2"
    const val descriptionOne = "description1"
    const val descriptionTwo = "description2"
    const val imgSrcOne = "imgSrc1"
    const val imgSrcTwo = "imgSrc2"

    val photosList = listOf(
        AmphibiansData(
            name = nameOne,
            type = typeOne,
            description = descriptionOne,
            imgSrc = imgSrcOne
        ),
        AmphibiansData(
            name = nameTwo,
            type = typeTwo,
            description = descriptionTwo,
            imgSrc = imgSrcTwo
    )
    )
}