package com.globant.marvelcharacters.data.repositoryimpl

import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.source.DataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MarvelCharactersListRepositoryImplTest {
    @Mock
    private lateinit var mapper: MarvelCharacterListResponseMapper

    @Mock
    private lateinit var remoteDataSource: DataSource.RemoteDataSource

    @Mock
    private lateinit var repository: MarvelCharactersListRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarvelCharactersListRepositoryImpl(remoteDataSource)
      //  repository
    }

    @Test
    fun getMarvelCharacterListTest(){
        runBlockingTest {
        }

        }
}