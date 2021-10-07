package com.gilangjs.blacklist.presentation.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gilangjs.blacklist.domain.interactors.DeleteItemUseCase
import com.gilangjs.blacklist.domain.interactors.GetItemListUseCase
import com.gilangjs.blacklist.domain.interactors.GetItemUseCase
import com.gilangjs.blacklist.domain.interactors.SaveItemUseCase
import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.presentation.BaseViewModel
import com.gilangjs.blacklist.presentation.features.main.MainViewModel.AppState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemListUseCase: GetItemListUseCase,
    private val getItemUseCase: GetItemUseCase,
    private val saveItemUseCase: SaveItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) : BaseViewModel() {
    private val _itemList = MutableLiveData<List<Item>>().apply { value = listOf() }
    private val _appState = MutableLiveData<AppState>().apply { value = AppState.SHOW_ITEM }
    private val _errorMessage = MutableLiveData<String>()
    private val _currentItem = MutableLiveData<Item?>()

    val currentItem: LiveData<Item?> = _currentItem
    val itemList: LiveData<List<Item>> get() = _itemList
    val appState: LiveData<AppState> get() = _appState
    val errorMessage: LiveData<String> get() = _errorMessage

    fun setParam(param: String?) {
        val regex = Regex("https?\\S*")
        val link = param?.let { regex.find(it)?.value }
        if (link == null) {
            _errorMessage.value = "Failed to parse link"
            return
        }

        viewModelScope.launch {
            val item = getItemUseCase(link)
            _appState.value =
                if (item.isSuccess) {
                    _currentItem.value = item.getOrNull()
                    ITEM_EXIST
                }
                else {
                    _currentItem.value = Item(link)
                    SAVE_ITEM
                }
        }
    }

    fun loadData() {
        viewModelScope.launch {
            val itemList = getItemListUseCase(Unit)
            if (itemList.isSuccess) {
                _itemList.value = itemList.getOrDefault(_itemList.value)
                _appState.value = SHOW_ITEM
            } else {
                _errorMessage.value = "Failed to load item list"
            }
        }
    }

    fun selectItem(item: Item) {
        _currentItem.value = item
        _appState.value = DELETE_ITEM
    }

    fun cancelSelectItem() {
        _currentItem.value = null
        _appState.value = SHOW_ITEM
    }

    fun saveCurrentItem() {
        val item = _currentItem.value ?: return
        viewModelScope.launch {
            val result = saveItemUseCase(item)
            if (result.isSuccess) loadData()
            else _errorMessage.value = "Failed to save item"
        }
    }

    fun deleteCurrentItem() {
        val item = _currentItem.value ?: return
        viewModelScope.launch {
            val result = deleteItemUseCase(item)
            if (result.isSuccess) loadData()
            else _errorMessage.value = "Failed to delete item"
        }
    }

    enum class AppState {
        SHOW_ITEM, DELETE_ITEM, SAVE_ITEM, ITEM_EXIST
    }
}

