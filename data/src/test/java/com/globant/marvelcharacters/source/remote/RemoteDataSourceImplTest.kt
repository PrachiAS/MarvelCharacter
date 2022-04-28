package com.globant.marvelcharacters.source.remote

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.mapper.MarvelCharacterDetailResponseMapper
import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.source.remote.RemoteDataSourceImpl
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
import com.globant.marvelcharacters.mockMarvelCharacterListDataResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

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
            whenever(service.getMarvelCharacterList()).thenReturn(mockMarvelCharacterListDataResponse)
            whenever(responseListMapper.toModel(any())).thenReturn(
                mockGetMarvelCharacterListResponse)
            val response = remoteDataSourceImpl.getMarvelCharacterList()

            verify(service).getMarvelCharacterList()
            assertEquals(mockGetMarvelCharacterListResponse.characterModel?.first()?.name, response.characterModel?.first()?.name)
            assertEquals(mockGetMarvelCharacterListResponse.characterModel?.first()?.id, response.characterModel?.first()?.id)
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