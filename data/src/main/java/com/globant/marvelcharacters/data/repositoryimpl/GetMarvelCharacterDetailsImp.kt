package com.globant.marvelcharacter.data.repository

import com.globant.marvelcharacter.data.model.MarvelCharactersDTO
import com.globant.marvelcharacter.data.source.remote.service.ApiService

class GetMarvelCharacterDetailsImp(private val marvelApi:ApiService):GetMarvelCharacterDetailsRepository {
    override suspend fun getMarvelCharacterDetails(id: String): MarvelCharactersDTO {
        return marvelApi.getMarvelCharactersDetails(id)
    }
}