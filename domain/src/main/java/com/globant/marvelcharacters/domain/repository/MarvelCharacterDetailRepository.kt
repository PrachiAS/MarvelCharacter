package com.globant.marvelcharacters.domain.repository

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

interface MarvelCharacterDetailRepository {
    suspend fun getMarvelCharacterDetail(id:String):
            MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse
}