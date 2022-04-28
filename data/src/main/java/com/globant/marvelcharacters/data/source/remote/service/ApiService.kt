package com.globant.marvelcharacter.data.source.remote.service

import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/public/characters")
    suspend fun getMarvelCharacterList(): MarvelCharactersResponse

    @GET ("v1/public/characters/{id}")
    suspend fun getMarvelCharacterDetails(@Path("id") id: String): MarvelCharactersResponse
}