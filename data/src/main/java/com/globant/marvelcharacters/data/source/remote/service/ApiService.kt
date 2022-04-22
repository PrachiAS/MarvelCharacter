package com.globant.marvelcharacter.data.source.remote.service

import com.globant.marvelcharacter.data.model.MarvelCharactersDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v1/public/characters")
    suspend fun getMarvelCharactersData(): MarvelCharactersDTO

    @GET("v1/public/characters")
    suspend fun getMarvelCharactersDetails(@Query("id")i:String): MarvelCharactersDTO
}