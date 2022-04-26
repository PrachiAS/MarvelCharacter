package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.model.CharacterListsModel

class CharacterListMapper {
    fun toModel(request: List<MarvelCharacterNameModel>?): CharacterListsModel {
        return CharacterListsModel(characterNamesList = request?.map { it.name })
    }
}

