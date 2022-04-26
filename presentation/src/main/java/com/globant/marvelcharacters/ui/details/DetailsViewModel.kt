package com.globant.marvelcharacters.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.globant.marvelcharacters.mapper.CharacterDetailMapper
import com.globant.marvelcharacters.model.CharacterDetailsModel
import com.globant.marvelcharacters.model.CharacterInfoModel
import com.globant.marvelcharacters.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val mapper: CharacterDetailMapper
) : BaseViewModel() {
    var characterDetailsModelLiveData = MutableLiveData<CharacterDetailsModel?>()

    fun init(infoModel: CharacterInfoModel?) {
        viewModelScope.launch {
            showLoading.postValue(true)
            infoModel?.let {
                showLoading.postValue(false)
                characterDetailsModelLiveData.postValue(
                    mapper.toModel(
                        name = it.name.toString(),
                        thumbnailUrl = it.thumbnailUrl.toString(),
                        description= it.description.toString(),
                        availableComics = "".plus(it.availableComics),
                        comicNames = it.comicNames,
                        availableSeries = it.availableSeries.toString(),
                        availableStories = it.availableStories.toString(),
                        availableEvents = it.availableEvents.toString()
                    )
                )
            }
        }
    }
}