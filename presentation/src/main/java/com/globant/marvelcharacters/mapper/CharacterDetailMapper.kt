package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.model.CharacterDetailsModel

class CharacterDetailMapper {
    fun toModel(
        name: String,
        thumbnailUrl: String,
        description: String,
        availableComics : String,
        comicNames: List<String>?=ArrayList<String>(),
        availableSeries : String,
        availableStories:String,
        availableEvents:String
    ): CharacterDetailsModel {
        return CharacterDetailsModel(
            name =  name,
            thumbnailUrl = thumbnailUrl,
            description = description,
            availableComics = availableComics,
            comicNames = comicNames,
            availableSeries = availableSeries,
            availableStories = availableStories,
            availableEvents = availableEvents,
        )
    }
}