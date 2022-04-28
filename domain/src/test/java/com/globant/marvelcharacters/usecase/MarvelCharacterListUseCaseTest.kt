package com.globant.marvelcharacters.usecase

import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MarvelCharacterListUseCaseTest {
    @Mock
    private lateinit var repository: MarvelCharacterListRepository

    private lateinit var useCase: MarvelCharacterListUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = MarvelCharacterListUseCase(repository)
    }

    @Test
    fun `executeUseCase should call repository`() {
        runBlockingTest {
            val mockResponse= mockGetMarvelCharacterListResponse
            val mockRequest = MarvelCharacterListUseCase.MarvelCharacterListRequest()

            whenever(repository.getMarvelCharacterList()).thenReturn(mockResponse)

            val response  = useCase.executeUseCase(mockRequest)
            verify(repository).getMarvelCharacterList()
            assertEquals(response.characterModel?.first()?.id,mockResponse.characterModel?.first()?.id )
            assertEquals(response.characterModel?.first()?.name,mockResponse.characterModel?.first()?.name )
            assertEquals(mockResponse, response)
        }
    }
}
