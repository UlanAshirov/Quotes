package com.example.quotes.presentation.model.translate

import com.example.quotes.domain.model.translate.TranslationModel

data class TranslationUI(
    val translatedText: String
)

fun TranslationModel.toUI() = TranslationUI(
    translatedText = translatedText
)
