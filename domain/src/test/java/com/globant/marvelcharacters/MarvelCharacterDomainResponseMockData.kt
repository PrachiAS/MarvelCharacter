package com.globant.marvelcharacters

import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

val mockGetMarvelCharacterListResponse = MarvelCharacterListUseCase.MarvelCharacterListResponse(
    characterModel = listOf(
        MarvelCharacterNameModel(1, "abc"),
        MarvelCharacterNameModel(2, "abcde")
    )
)

val mockMarvelCharacterDetailsResponse =
    MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse(
        characterModel = MarvelCharacterDetails(
            id = 5,
            name = "abc",
            thumbnailUrl = "http://thumbnail.url.jpg",
            description = "This is dummy data",
            availableComics = 4,
            comicNames = listOf("ABC", "XYZ"),
            availableSeries = 5,
            availableStories = 3,
            availableEvents = 2
        )
    )



