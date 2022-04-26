package com.globant.marvelcharacter.data.source.remote.service

import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v1/public/characters")
    suspend fun getMarvelCharacterList(): MarvelCharactersResponse
}