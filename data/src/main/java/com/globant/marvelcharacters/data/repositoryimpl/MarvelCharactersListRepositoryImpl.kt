package com.globant.marvelcharacters.data.repositoryimpl

import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import javax.inject.Inject

class MarvelCharactersListRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource.RemoteDataSource) :
    MarvelCharacterListRepository {

    override suspend fun getMarvelCharacterList(): MarvelCharacterListUseCase.MarvelCharacterListResponse =
        remoteDataSource.getMarvelCharacterList()
}