package com.globant.marvelcharacters.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterInfoModel(
    val id: Int,
    val name: String?,
    val thumbnailUrl: String?,
    val description: String?,
    val availableComics: Int?,
    val comicNames: List<String>?,
    val availableSeries: Int?,
    val availableStories: Int?,
    val availableEvents: Int?
) : Parcelable

@Parcelize
data class CharacterListsModel(val characterNamesList: List<String>?) : Parcelable

@Parcelize
data class CharacterDetailsModel(
    val name: String? = "",
    val thumbnailUrl: String? = "",
    val description: String? = "",
    val availableComics: String? = "",
    val comicNames: List<String>? = ArrayList<String>(),
    val availableSeries: String? = "",
    val availableStories: String? = "",
    val availableEvents: String? = "",
) : Parcelable
