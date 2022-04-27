package com.globant.marvelcharacters.data.source.remote

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.mapper.MarvelCharacterDetailResponseMapper
import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteService: ApiService,
    private val responseListMapper: MarvelCharacterListResponseMapper,
    private val responseDetailMapper: MarvelCharacterDetailResponseMapper
) :
    DataSource.RemoteDataSource {
    override suspend fun getMarvelCharacterList(): MarvelCharacterListUseCase.MarvelCharacterListResponse? =
        try {
            responseListMapper.toModel(remoteService.getMarvelCharacterList())
        } catch (error: Exception) {
            null
        }

    override suspend fun getMarvelCharacterDetails(id: String): MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse? =
        try {
            responseDetailMapper.toModel(remoteService.getMarvelCharacterDetails(id))
        } catch (error: Exception) {
            null
        }
}
