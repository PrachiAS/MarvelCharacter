package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.mockCharacterNamesPresenterModel
import com.globant.marvelcharacters.mockMarvelCharacterNameDomainModelList
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CharacterListMapperTest {
    private lateinit var mapper: CharacterListMapper

    @Before
    fun setup() {
        mapper = CharacterListMapper()
    }

    @Test
    fun `toModel for non null should return CharacterNamesModel`() {
        val model = mapper.toModel(mockMarvelCharacterNameDomainModelList)
        assertEquals(mockCharacterNamesPresenterModel, model)
    }

    @Test
    fun `toModel for null should return null character name list`() {
        val model = mapper.toModel(null)
        assertEquals(mockCharacterNamesPresenterModel.copy(null), model)
    }
}