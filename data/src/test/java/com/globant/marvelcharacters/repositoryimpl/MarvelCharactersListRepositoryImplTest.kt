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

    @Mock
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    private lateinit var repository: MarvelCharactersListRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarvelCharactersListRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getMarvelCharacterListTest() {
        runBlockingTest {

            whenever(remoteDataSource.getMarvelCharacterList()).thenReturn(mockGetMarvelCharacterListResponse)

            val response  = repository.getMarvelCharacterList()

            verify(remoteDataSource).getMarvelCharacterList()
            Assert.assertEquals(
                response.characterModel?.first()?.id,
                mockGetMarvelCharacterListResponse.characterModel?.first()?.id
            )
            Assert.assertEquals(
                response.characterModel?.first()?.name,
                mockGetMarvelCharacterListResponse.characterModel?.first()?.name
            )
            Assert.assertEquals(mockGetMarvelCharacterListResponse, response)
        }
    }
}