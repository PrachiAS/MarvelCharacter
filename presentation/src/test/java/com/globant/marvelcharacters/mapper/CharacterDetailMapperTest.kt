package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.mockModelCharacterPresenterDetails
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CharacterDetailMapperTest {
    private lateinit var mapper: CharacterDetailMapper

    @Before
    fun setUp() {
        mapper = CharacterDetailMapper()
    }

    @Test
    fun `toModel for non null input should return CharacterDetailsModel`() {
        val model = mapper.toModel(
            "A.I.M",
            "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec.jpg",
            "AIM is a terrorist organization bent on destroying the world",
            "1",
            listOf("ABC", "XYZ"),
            "5",
            "3",
            "2"
        )
        assertEquals(mockModelCharacterPresenterDetails, model)
    }

}