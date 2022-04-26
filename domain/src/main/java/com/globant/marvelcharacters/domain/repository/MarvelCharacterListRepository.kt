package com.globant.marvelcharacters.domain.repository

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

interface MarvelCharacterListRepository {
    suspend fun getMarvelCharacterList(): MarvelCharacterListUseCase.MarvelCharacterListResponse
}