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

   /* @Mock
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    @Mock
    private lateinit var repository: MarvelCharactersDetailRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarvelCharactersDetailRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getMarvelCharacterListTest() {
        runBlockingTest {

            val mockId:String = "101"
            repository.getMarvelCharacterDetail(mockId)
            val mockResponse= mockMarvelCharacterDetailsResponse;

            whenever(repository.getMarvelCharacterDetail(mockId)).thenReturn(mockResponse)

            val response  = repository.getMarvelCharacterDetail(mockId)

            verify(repository).getMarvelCharacterDetail(mockId)
            Assert.assertEquals(response.characterModel?.id, mockResponse.characterModel?.id)
            Assert.assertEquals(response.characterModel?.name, mockResponse.characterModel?.name)
            Assert.assertEquals(response.characterModel?.thumbnailUrl, mockResponse.characterModel?.thumbnailUrl)
            Assert.assertEquals(response.characterModel?.description, mockResponse.characterModel?.description)
            Assert.assertEquals(response.characterModel?.availableStories, mockResponse.characterModel?.availableStories)
            Assert.assertEquals(response.characterModel?.comicNames, mockResponse.characterModel?.comicNames)
            Assert.assertEquals(response.characterModel?.availableComics, mockResponse.characterModel?.availableComics)
            Assert.assertEquals(response.characterModel?.availableEvents, mockResponse.characterModel?.availableEvents)
            Assert.assertEquals(response.characterModel?.availableSeries, mockResponse.characterModel?.availableSeries)
            Assert.assertEquals(mockResponse, response)
        }
    }*/
}