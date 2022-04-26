package com.globant.marvelcharacters.data.source.remote

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.data.source.DataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val remoteService: ApiService) :
    DataSource.RemoteDataSource {

    override suspend fun getMarvelCharacterList(): MarvelCharactersResponse? =
        try {
            remoteService.getMarvelCharacterList()
        } catch (error: Exception) {
            null
        }
    }
