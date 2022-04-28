package com.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
import com.globant.marvelcharacters.mockMarvelCharacterListDataResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class MarvelCharacterListResponseMapperTest {
    private lateinit var mapper: MarvelCharacterListResponseMapper

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        mapper = MarvelCharacterListResponseMapper()
    }

    @Test
    fun `toModel for valid data should return use case response`() {
        val response = mapper.toModel(mockMarvelCharacterListDataResponse)
        Assert.assertEquals(
            mockGetMarvelCharacterListResponse.characterModel?.first()?.name,
            response.characterModel?.first()?.name
        )
        Assert.assertEquals(
            mockGetMarvelCharacterListResponse.characterModel?.first()?.id,
            response.characterModel?.first()?.id
        )
        Assert.assertFalse(response.error)
    }

    @Test
    fun `toModel for invalid data should return use case response error`() {
        val response = mapper.toModel(null)
        Assert.assertTrue(response.error)
    }
}