package com.globant.marvelcharacters.data.mapper

import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

class MarvelCharacterListResponseMapper :
    ResponseMapper<MarvelCharactersResponse?, MarvelCharacterListUseCase.MarvelCharacterListResponse> {

    override fun toModel(response: MarvelCharactersResponse?):
            MarvelCharacterListUseCase.MarvelCharacterListResponse =
        when (response) {
            null -> MarvelCharacterListUseCase.MarvelCharacterListResponse(
                characterModel = null,
                error = true
            )
            else -> MarvelCharacterListUseCase.MarvelCharacterListResponse(characterModel = response.data.results.map {
                with(it) {
                    MarvelCharacterNameModel(id, name)
                }
            })
        }
}
