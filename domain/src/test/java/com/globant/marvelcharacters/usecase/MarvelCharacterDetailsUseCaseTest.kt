package com.globant.marvelcharacters.usecase

import com.globant.marvelcharacters.domain.repository.MarvelCharacterDetailRepository
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MarvelCharacterDetailsUseCaseTest {
    @Mock
    private lateinit var repository: MarvelCharacterDetailRepository

    private lateinit var useCase: MarvelCharacterDetailsUseCase

    @Mock
    private lateinit var request: MarvelCharacterDetailsUseCase.MarvelCharacterDetailRequest

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
            useCase.executeUseCase(request)
            whenever(repository.getMarvelCharacterDetail("101")).thenReturn(
                response
            )
        }
    }
}