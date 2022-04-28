package com.globant.marvelcharacters.domain.model

data class MarvelCharacterDetails(
    val id: Int,
    val name: String,
    val thumbnailUrl: String,
    val description: String,
    val availableComics: Int,
    val comicNames: List<String>,
    val availableSeries: Int,
    val availableStories: Int,
    val availableEvents: Int
)