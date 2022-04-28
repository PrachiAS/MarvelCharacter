package com.globant.marvelcharacters.usecase

import com.globant.marvelcharacters.domain.repository.MarvelCharacterDetailRepository
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
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
class MarvelCharacterDetailsUseCaseTest {
    @Mock
    private lateinit var repository: MarvelCharacterDetailRepository

    private lateinit var useCase: MarvelCharacterDetailsUseCase

    @Mock
    lateinit var response: MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = MarvelCharacterDetailsUseCase(repository)
    }

    @Test
    fun `executeUseCase should call repository`() {
        runBlockingTest {

            val mockId = "101"
            val mockResponse= mockMarvelCharacterDetailsResponse;
            val mockRequest = MarvelCharacterDetailsUseCase.MarvelCharacterDetailRequest(mockId)

            whenever(repository.getMarvelCharacterDetail(mockId)).thenReturn(mockResponse)

            val response  = useCase.executeUseCase(mockRequest)
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
    }
}