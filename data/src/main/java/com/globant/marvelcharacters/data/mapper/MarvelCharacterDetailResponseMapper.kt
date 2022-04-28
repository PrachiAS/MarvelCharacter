package com.globant.marvelcharacters.data.mapper

import com.globant.marvelcharacters.data.common.DataConstants
import com.globant.marvelcharacters.data.model.Comics
import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase

class MarvelCharacterDetailResponseMapper :
    ResponseMapper<MarvelCharactersResponse?, MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse> {

    override fun toModel(response: MarvelCharactersResponse?): MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse =
        when (response) {
            null -> MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse(
                characterModel = null,
                error = true
            )
            else ->
                with(
                    response.data.results.first()
                ) {
                    MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse(
                        characterModel = MarvelCharacterDetails(
                            id = this.id,
                            name = this.name,
                            thumbnailUrl = this.thumbnail.path + DataConstants.dot + this.thumbnail.extension,
                            description = this.description,
                            availableComics = this.comics.available,
                            comicNames = getComicNames(this.comics),
                            availableSeries = this.series.available,
                            availableStories = this.stories.available,
                            availableEvents = this.events.available
                        )
                    )
                }
        }

    private fun getComicNames(comic: Comics): List<String> {
        val comicItemList = ArrayList<String>()
        for (items in comic.items) {
            comicItemList.add(items.name)
        }
        return comicItemList
    }
}