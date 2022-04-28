package com.globant.marvelcharacters.data.repositoryimpl

import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.domain.repository.MarvelCharacterDetailRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import javax.inject.Inject

class MarvelCharactersDetailRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource.RemoteDataSource) :
    MarvelCharacterDetailRepository {

    override suspend fun getMarvelCharacterDetail(id: String): MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse =
        remoteDataSource.getMarvelCharacterDetails(id)
}

