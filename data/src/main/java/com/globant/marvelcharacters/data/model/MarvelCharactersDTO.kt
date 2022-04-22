package com.globant.marvelcharacters.data.model

import com.globant.marvelcharacters.domain.model.MarvelCharacter

data class MarvelCharactersDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
)

