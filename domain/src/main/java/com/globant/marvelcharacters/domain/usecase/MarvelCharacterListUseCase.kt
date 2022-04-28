package com.globant.marvelcharacters.domain.usecase

import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import javax.inject.Inject

class MarvelCharacterListUseCase @Inject constructor(private val repository: MarvelCharacterListRepository) :
    BaseUseCase<MarvelCharacterListUseCase.MarvelCharacterListRequest, MarvelCharacterListUseCase.MarvelCharacterListResponse>() {

    class MarvelCharacterListRequest : Request

    class MarvelCharacterListResponse(
        val characterModel: List<MarvelCharacterNameModel>?,
        val error: Boolean = false
    ) : Response

    override suspend fun executeUseCase(request: MarvelCharacterListRequest): MarvelCharacterListResponse =
        repository.getMarvelCharacterList()
}