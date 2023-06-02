package com.example.quotes.domain.usecases

import com.example.quotes.domain.repository.TranslateRepository

class GetTranslateTextUseCase(private val repository: TranslateRepository) {

    operator fun invoke(translateText: String) = repository.getTranslateText(translateText)
}