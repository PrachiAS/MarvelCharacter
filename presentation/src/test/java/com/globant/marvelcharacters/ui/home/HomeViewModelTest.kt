package com.globant.marvelcharacters.ui.home

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.mockGetMarvelCharacterListResponse
import com.globant.marvelcharacters.ui.BaseViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseViewModelTest() {

   /* @Mock
    private lateinit var searchCharacterUseCase: MarvelCharacterListUseCase
    private lateinit var viewModel: HomeViewModel

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        viewModel =
            HomeViewModel(
                searchCharacterUseCase
            )
    }*/
/*
    @Test
    fun `onItemClickListener should post value to characterDetails`() {
        testScope.runBlockingTest {
            whenever(
                searchCharacterUseCase.executeUseCase(
                    any()
                )
            ).thenReturn(
                //mockGetMarvelCharacterListResponse
            )

        }
    }*/
}