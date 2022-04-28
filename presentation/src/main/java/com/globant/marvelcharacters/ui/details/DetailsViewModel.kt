package com.globant.marvelcharacters.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val marvelCharacterDetailsUseCase: MarvelCharacterDetailsUseCase
) : BaseViewModel() {
    var characterDetailsModelLiveData = MutableLiveData<MarvelCharacterDetails?>()

    fun getMarvelCharacterDetails(id: String) {
        showSuccess.postValue(false)
        showError.postValue(false)
        showLoading.postValue(true)
        viewModelScope.launch {
            val response = marvelCharacterDetailsUseCase.executeUseCase(
                MarvelCharacterDetailsUseCase.MarvelCharacterDetailRequest(id)
            )
            when (response.error) {
                true -> {
                    showSuccess.postValue(false)
                    showError.postValue(true)
                    showLoading.postValue(false)
                }
                false -> {
                    showSuccess.postValue(true)
                    showLoading.postValue(false)
                    showError.postValue(false)
                    characterDetailsModelLiveData.postValue(response.characterModel)
                }
            }
        }
    }
}
