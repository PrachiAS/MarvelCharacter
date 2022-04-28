package com.globant.marvelcharacters.domain.usecase

import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.repository.MarvelCharacterDetailRepository
import javax.inject.Inject

class MarvelCharacterDetailsUseCase @Inject constructor(private val repository: MarvelCharacterDetailRepository)

    :
    BaseUseCase<MarvelCharacterDetailsUseCase.MarvelCharacterDetailRequest, MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse>() {

    class MarvelCharacterDetailRequest(val id: String) : Request

    class MarvelCharacterDetailResponse(
        val characterModel: MarvelCharacterDetails?,
        val error: Boolean = false
    ) : Response

    override suspend fun executeUseCase(request: MarvelCharacterDetailRequest): MarvelCharacterDetailResponse =
        repository.getMarvelCharacterDetail(request.id)
}

