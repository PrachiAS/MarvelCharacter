package com.globant.marvelcharacters.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.mapper.CharacterListMapper
import com.globant.marvelcharacters.model.CharacterInfoModel
import com.globant.marvelcharacters.model.CharacterListsModel
import com.globant.marvelcharacters.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import om.globant.marvelcharacters.mapper.CharacterInfoMapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val marvelCharacterListUseCase: MarvelCharacterListUseCase,
    private val characterInfoMapper: CharacterInfoMapper,
    private val characterNameMapper: CharacterListMapper
) :
    BaseViewModel() {
    private var characterDetailList: List<MarvelCharacterDetails>? = null
    val characterNameList = MutableLiveData<CharacterListsModel>()
    val characterDetail = MutableLiveData<CharacterInfoModel>()

    init {
        getMarvelCharacter()
    }
    val onListItemClickListener: (position: Int) -> Unit = {
        characterDetail.postValue(
            characterInfoMapper.toModel(characterDetailList?.get(it))
        )
    }

    public fun getMarvelCharacter() {
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
                            characterNameList.postValue(
                                characterNameMapper.toModel(response.characterModel?.map { it.first }
                                    ?.toList()))
                            characterDetailList = response.characterModel?.map { it.second }
                        }
                    }
                }
            }
        }
    }
}