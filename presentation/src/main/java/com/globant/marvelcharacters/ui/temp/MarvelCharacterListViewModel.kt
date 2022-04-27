package com.globant.marvelcharacters.ui.temp

import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.model.CharacterInfoModel
import com.globant.marvelcharacters.model.CharacterListsModel
import com.globant.marvelcharacters.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelCharacterListViewModel @Inject constructor(
   // private val coroutineScopeProvider: CoroutineScope? = null,
    private val searchCharacterUseCase: MarvelCharacterListUseCase
) :
    BaseViewModel() {

   // private val coroutineScope = getViewModelScope(coroutineScopeProvider)
    private var characterDetailList: List<MarvelCharacterDetails>? = null
    val characterNameList = MutableLiveData<CharacterListsModel>()
    val characterDetail = MutableLiveData<CharacterInfoModel>()


   /* var marvelData = liveData<CharacterListsModel> {


        searchCharacter()
    }*/

    val onListItemClickListener: (position: Int) -> Unit = {
        /*characterDetail.postValue(
            characterInfoMapper.toModel(characterDetailList?.get(it))
        )*/
    }

    val queryTextListener = object : OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            searchCharacter()
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return true
        }

    }

    private fun searchCharacter() {
        showSuccess.postValue(false)
        showError.postValue(false)
        showLoading.postValue(true)
        viewModelScope.launch {
            val response = searchCharacterUseCase.executeUseCase(
                MarvelCharacterListUseCase.MarvelCharacterListRequest(
                )
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
                           /* characterNameList.postValue(
                                characterNameMapper.toModel(response.characterModel?.map { it.first }
                                    ?.toList()))
                            characterDetailList = response.characterModel?.map { it.second }*/
                        }
                    }

                }
            }
        }
    }

}