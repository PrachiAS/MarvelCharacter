package com.globant.marvelcharacters.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val marvelCharacterListUseCase: MarvelCharacterListUseCase
) :
    BaseViewModel() {
    val characterNameList = MutableLiveData<List<MarvelCharacterNameModel>>()

     fun getMarvelCharacter() {
        showSuccess.postValue(false)
        showError.postValue(false)
        showLoading.postValue(true)
        viewModelScope.launch {
            val response = marvelCharacterListUseCase.executeUseCase(
                MarvelCharacterListUseCase.MarvelCharacterListRequest()
            )
            when (response.error) {
                true -> {
                    showSuccess.postValue(false)
                    showError.postValue(true)
                    showLoading.postValue(false)
                }
                false -> {
                    when (response.characterModel?.size?.compareTo(0)) {
                        0 -> {
                            showSuccess.postValue(false)
                            showError.postValue(true)
                            showLoading.postValue(false)
                        }
                        else -> {
                            showSuccess.postValue(true)
                            showLoading.postValue(false)
                            showError.postValue(false)
                            characterNameList.postValue(response.characterModel)
                        }
                    }
                }
            }
        }
    }
}