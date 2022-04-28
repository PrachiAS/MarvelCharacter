package com.globant.marvelcharacters.repositoryimpl

import com.globant.marvelcharacters.data.repositoryimpl.MarvelCharactersListRepositoryImpl
import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
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
class MarvelCharactersListRepositoryImplTest {

  /*  @Mock
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    @Mock
    private lateinit var repository: MarvelCharactersListRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarvelCharactersListRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getMarvelCharacterListTest() {
        runBlockingTest {

            repository.getMarvelCharacterList()
            val mockResponse= mockGetMarvelCharacterListResponse;

            whenever(repository.getMarvelCharacterList()).thenReturn(mockResponse)

            val response  = repository.getMarvelCharacterList()

            verify(repository).getMarvelCharacterList()
            Assert.assertEquals(
                response.characterModel?.first()?.id,
                mockResponse.characterModel?.first()?.id
            )
            Assert.assertEquals(
                response.characterModel?.first()?.name,
                mockResponse.characterModel?.first()?.name
            )
            Assert.assertEquals(mockResponse, response)
        }
    }*/
}