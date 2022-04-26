package com.globant.marvelcharacters.domain.model

class MarvelCharacterDetails(
    val name: String,
    val thumbnailUrl: String,
    val description: String,
    val availableComics: Int,
    val comicNames: List<String>,
    val availableSeries: Int,
    val availableStories: Int,
    val availableEvents: Int
)