package com.globant.marvelcharacters.domain.repository

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase

interface MarvelCharacterDetailRepository {
    suspend fun getMarvelCharacterDetail(id: String): MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse
}