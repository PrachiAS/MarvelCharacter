package com.globant.marvelcharacters.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showLoading = MutableLiveData<Boolean>(false)
    val showError = MutableLiveData<Boolean>(false)
    val showSuccess = MutableLiveData<Boolean>(false)
}
