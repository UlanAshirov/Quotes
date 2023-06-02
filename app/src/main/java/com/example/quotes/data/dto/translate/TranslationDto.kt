package com.example.quotes.data.dto.translate

import com.example.quotes.data.mapper.DataMapper
import com.example.quotes.domain.model.translate.TranslationModel

data class TranslationDto(
    val translatedText: String
) : DataMapper<TranslationModel> {
    override fun toDomain() = TranslationModel(
        translatedText = translatedText
    )
}