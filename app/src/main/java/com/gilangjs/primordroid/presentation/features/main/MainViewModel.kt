package com.gilangjs.primordroid.presentation.features.main

import com.gilangjs.primordroid.domain.interactors.GetUserListUseCase
import com.gilangjs.primordroid.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : BaseViewModel() {

}
