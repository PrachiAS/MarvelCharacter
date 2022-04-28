package com.globant.marvelcharacters.ui.details

import com.globant.marvelcharacters.ui.BaseViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class DetailsViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var mapper: CharacterDetailMapper

    private lateinit var viewModel: DetailsViewModel

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        viewModel = DetailsViewModel(
            mapper
        )
    }

}