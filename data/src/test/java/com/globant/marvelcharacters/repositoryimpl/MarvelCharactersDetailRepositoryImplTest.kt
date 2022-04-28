package com.globant.marvelcharacters.repositoryimpl

import com.globant.marvelcharacters.data.repositoryimpl.MarvelCharactersDetailRepositoryImpl
import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.mockMarvelCharacterDetailsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MarvelCharactersDetailRepositoryImplTest {

    @Mock
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    private lateinit var repository: MarvelCharactersDetailRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarvelCharactersDetailRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getMarvelCharacterListTest() {
        runBlockingTest {
            val mockId = "101"
            whenever(remoteDataSource.getMarvelCharacterDetails(mockId)).thenReturn(mockMarvelCharacterDetailsResponse)

            val response  = repository.getMarvelCharacterDetail(mockId)

            verify(remoteDataSource).getMarvelCharacterDetails(mockId)
            Assert.assertEquals(response.characterModel?.id, mockMarvelCharacterDetailsResponse.characterModel?.id)
            Assert.assertEquals(response.characterModel?.name, mockMarvelCharacterDetailsResponse.characterModel?.name)
            Assert.assertEquals(response.characterModel?.thumbnailUrl, mockMarvelCharacterDetailsResponse.characterModel?.thumbnailUrl)
            Assert.assertEquals(response.characterModel?.description, mockMarvelCharacterDetailsResponse.characterModel?.description)
            Assert.assertEquals(response.characterModel?.availableStories, mockMarvelCharacterDetailsResponse.characterModel?.availableStories)
            Assert.assertEquals(response.characterModel?.comicNames, mockMarvelCharacterDetailsResponse.characterModel?.comicNames)
            Assert.assertEquals(response.characterModel?.availableComics, mockMarvelCharacterDetailsResponse.characterModel?.availableComics)
            Assert.assertEquals(response.characterModel?.availableEvents, mockMarvelCharacterDetailsResponse.characterModel?.availableEvents)
            Assert.assertEquals(response.characterModel?.availableSeries, mockMarvelCharacterDetailsResponse.characterModel?.availableSeries)
            Assert.assertEquals(mockMarvelCharacterDetailsResponse, response)
        }
    }
}