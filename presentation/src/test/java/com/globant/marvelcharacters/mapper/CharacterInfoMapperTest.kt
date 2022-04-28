package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.characterInfoModel
import com.globant.marvelcharacters.mockModelCharacterDomainDetails
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CharacterInfoMapperTest {
    private lateinit var mapper: CharacterInfoMapper

    @Before
    fun setup() {
        mapper = CharacterInfoMapper()
    }

    @Test
    fun `toModel for non null should return CharacterInfoModel`() {
        val model = mapper.toModel(mockModelCharacterDomainDetails)
        assertEquals(characterInfoModel, model)
    }
}