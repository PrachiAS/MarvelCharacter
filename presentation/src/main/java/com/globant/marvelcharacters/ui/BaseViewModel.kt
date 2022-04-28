package com.globant.marvelcharacters.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showLoading = MutableLiveData(false)
    val showError = MutableLiveData(false)
    val showSuccess = MutableLiveData(false)
}
