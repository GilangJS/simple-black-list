package com.gilangjs.blacklist.presentation.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gilangjs.blacklist.domain.interactors.GetUserListUseCase
import com.gilangjs.blacklist.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : BaseViewModel() {
    private val _param = MutableLiveData<String?>()

    val param: LiveData<String?> get() = _param

    fun setParam(param: String?) {
        val regex = Regex("https?\\S*")
        val link = param?.let { regex.find(it)?.value }
        _param.value = link
    }
}
