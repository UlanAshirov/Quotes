package com.example.quotes.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.common.Resource
import com.example.quotes.presentation.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> mutableUIStateFlow() = MutableStateFlow<UIState<List<T>>>(UIState.Idle())


}
