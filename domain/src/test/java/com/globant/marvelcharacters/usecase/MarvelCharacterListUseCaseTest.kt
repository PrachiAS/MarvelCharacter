package com.globant.marvelcharacters.usecase

import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MarvelCharacterListUseCaseTest {
    @Mock
    private lateinit var repository: MarvelCharacterListRepository

    private lateinit var useCase: MarvelCharacterListUseCase

    @Mock
    private lateinit var request: MarvelCharacterListUseCase.MarvelCharacterListRequest

    @Mock
    lateinit var response: MarvelCharacterListUseCase.MarvelCharacterListResponse

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = MarvelCharacterListUseCase(repository)
    }

    @Test
    fun `executeUseCase should call repository`() {
        runBlockingTest {
            useCase.executeUseCase(request)
            whenever(repository.getMarvelCharacterList()).thenReturn(
                response
            )
        }
    }
}