package com.globant.marvelcharacters.ui.home

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase

import com.globant.marvelcharacters.ui.BaseViewModelTest
import com.globant.marvelcharacters.ui.mockGetMarvelCharacterListResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var getMarvelCharacterListUseCase: MarvelCharacterListUseCase

    private lateinit var viewModel: HomeViewModel

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        viewModel = HomeViewModel(getMarvelCharacterListUseCase)
    }

    @Test
    fun `getMarvelCharacter should fetch charcaters list`() {
        runBlockingTest {

            whenever(getMarvelCharacterListUseCase.executeUseCase(any())
            ).thenReturn(mockGetMarvelCharacterListResponse)

            viewModel.getMarvelCharacter()

            assertEquals(viewModel.showSuccess.value, true)
            assertEquals(viewModel.showError.value, false)
            assertEquals(viewModel.showLoading.value, false)
        }
    }
}