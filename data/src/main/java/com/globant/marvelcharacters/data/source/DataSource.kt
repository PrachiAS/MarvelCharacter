package com.globant.marvelcharacters.data.source

import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

interface DataSource {
    interface RemoteDataSource {
        suspend fun getMarvelCharacterList(): MarvelCharacterListUseCase.MarvelCharacterListResponse?
        suspend fun getMarvelCharacterDetails(id: String): MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse?
    }
}