package com.globant.marvelcharacters.source.remote

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.mapper.MarvelCharacterDetailResponseMapper
import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.source.remote.RemoteDataSourceImpl
import com.globant.marvelcharacters.mockMarvelCharacterListResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class RemoteDataSourceImplTest {

    @Mock
    private lateinit var service: ApiService
    @Mock
    private lateinit var responseListMapper: MarvelCharacterListResponseMapper
    @Mock
    private lateinit var responseDetailMapper: MarvelCharacterDetailResponseMapper

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl = RemoteDataSourceImpl(service,responseListMapper,responseDetailMapper)
    }

    @Test
    fun `get marvel character list should return response from ApiService`() {
        runBlockingTest {
            whenever(service.getMarvelCharacterList()).thenReturn(mockMarvelCharacterListResponse)
            val response = remoteDataSourceImpl.getMarvelCharacterList()
            verify(service).getMarvelCharacterList()
            assertEquals(mockMarvelCharacterListResponse, response)
        }
    }

    @Test
    fun `get marvel character list for invalid data should return null`() {
        runBlockingTest {
            whenever(service.getMarvelCharacterList()).thenReturn(null)
            val response = remoteDataSourceImpl.getMarvelCharacterList()
            verify(service).getMarvelCharacterList()
            assertEquals(null, response)
        }
    }
}