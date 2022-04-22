package com.globant.marvelcharacter.data.repository

import com.globant.marvelcharacter.data.model.MarvelCharactersDTO
import com.globant.marvelcharacter.data.source.remote.service.ApiService

class GetMarvelCharacterListImp(private val marvelCharacterApi:ApiService):MarvelCharacterListRepository {
    override suspend fun getMarvelCharacterList(): MarvelCharactersDTO {
        return marvelCharacterApi.getMarvelCharactersData()
    }
}