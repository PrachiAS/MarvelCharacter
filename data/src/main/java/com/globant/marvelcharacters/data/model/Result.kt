package com.globant.marvelcharacters.data.model

import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.model.MarvelCharacter


data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String?,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)

fun Result.toDomainMarvelCharacter(): MarvelCharacter {
    return MarvelCharacter(
        id = this.id,
        name = this.name ?: "",
        thumbnailUrl = this.thumbnail.path.plus(".").plus(this.thumbnail.extension)
    )
}

fun Result.toDomainMarvelCharacterDetails(): MarvelCharacterDetails {
    return MarvelCharacterDetails(

        name = this.name ?: "",
        thumbnailUrl = this.thumbnail.path.plus(".").plus(this.thumbnail.extension),
        availableComics = this.comics.available,
        comicNames = getComicNames(this.comics),
        availableStories = this.stories.available,
        availableSeries = this.series.available,
        availableEvents = this.events.available
    )
}

fun getComicNames(comics: Comics): List<String> {
    val comicItemList = ArrayList<String>()
    for (items in comics.items) {
        comicItemList.add(items.name)
    }
    return comicItemList
}