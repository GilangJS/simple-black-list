package com.gilangjs.blacklist.presentation.features.main

import com.gilangjs.blacklist.domain.interactors.GetUserListUseCase
import com.gilangjs.blacklist.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : BaseViewModel() {

}
