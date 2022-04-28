package com.globant.marvelcharacters.ui.details

import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase

import com.globant.marvelcharacters.ui.BaseViewModelTest
import com.globant.marvelcharacters.ui.mockMarvelCharacterDetailsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class DetailsViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var getMarvelCharacterDetailsUseCase: MarvelCharacterDetailsUseCase

    private lateinit var viewModel: DetailsViewModel

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        viewModel = DetailsViewModel(getMarvelCharacterDetailsUseCase)
    }

    @Test
    fun `getMarvelCharacterDetails should get characterDetails from network`() {
        testScope.runBlockingTest {
            whenever(getMarvelCharacterDetailsUseCase.executeUseCase(any())
            ).thenReturn(mockMarvelCharacterDetailsResponse)

            viewModel.getMarvelCharacterDetails("101")

            Assert.assertEquals(viewModel.showSuccess.value, true)
            Assert.assertEquals(viewModel.showError.value, false)
            Assert.assertEquals(viewModel.showLoading.value, false)
        }
    }
}