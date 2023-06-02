package com.example.quotes.presentation.ui.fragments.dialog

import androidx.lifecycle.viewModelScope
import com.example.quotes.base.BaseViewModel
import com.example.quotes.common.Resource
import com.example.quotes.domain.usecases.GetQuoteUseCase
import com.example.quotes.domain.usecases.GetTranslateTextUseCase
import com.example.quotes.presentation.model.quote.QuoteUI
import com.example.quotes.presentation.model.quote.toUI
import com.example.quotes.presentation.model.translate.TranslationUI
import com.example.quotes.presentation.model.translate.toUI
import com.example.quotes.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DialogViewModel(
    private val getQuoteUseCase: GetQuoteUseCase,
    private val getTranslateTextUseCase: GetTranslateTextUseCase
) : BaseViewModel() {

    private val _quoteState = MutableStateFlow<UIState<List<QuoteUI>>>(UIState.Idle())
    val quoteState = _quoteState.asStateFlow()

    private val _translateState = MutableStateFlow<UIState<List<TranslationUI>>>(UIState.Idle())
    val translateState = _translateState.asStateFlow()

    fun getQuote(category: String) {
        viewModelScope.launch {
            getQuoteUseCase(category).collect { quoteModel ->
                when (quoteModel) {
                    is Resource.Success -> {
                        _quoteState.value =
                            UIState.Success(data = quoteModel.data!!.map { it.toUI() })
                    }
                    is Resource.Loading -> {
                        _quoteState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _quoteState.value =
                            UIState.Error(msg = quoteModel.message ?: "Unknown error")
                    }
                }
            }
        }
    }

    fun getTranslateText(translateText: String) {
        viewModelScope.launch {
            getTranslateTextUseCase(translateText).collect { translateText ->
                when(translateText) {
                    is Resource.Success -> {
                        _translateState.value =
                            UIState.Success(data = translateText.data!!.map { it.toUI() })
                    }
                    is Resource.Loading -> {
                        _translateState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _translateState.value =
                            UIState.Error(msg = translateText.message ?: "Unknown error")
                    }
                }
            }
        }
    }
}