package com.globant.marvelcharacters.data.mapper

import com.globant.marvelcharacters.data.model.Comics
import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

class MarvelCharacterListResponseMapper :
    ResponseMapper<MarvelCharactersResponse?, MarvelCharacterListUseCase.MarvelCharacterListResponse> {

    override fun toModel(response: MarvelCharactersResponse?): MarvelCharacterListUseCase.MarvelCharacterListResponse =
        when (response) {
            null -> MarvelCharacterListUseCase.MarvelCharacterListResponse(
                characterModel = null,
                error = true
            )
            else -> MarvelCharacterListUseCase.MarvelCharacterListResponse(characterModel = response.data.results.map {
                with(it) {
                    MarvelCharacterNameModel( name)to MarvelCharacterDetails(
                        name = name ?: "",
                        thumbnailUrl = thumbnail.path.plus(".").plus(this.thumbnail.extension),
                        description = description,
                        availableComics = comics.available,
                        comicNames = getComicNames(comics),
                        availableStories = stories.available,
                        availableSeries = series.available,
                        availableEvents = events.available
                    )
                }
            })
        }

    fun getComicNames(comic: Comics): List<String> {
        val comicItemList = ArrayList<String>()
        for (items in comic.items) {
            comicItemList.add(items.name)
        }
        return comicItemList
    }
}