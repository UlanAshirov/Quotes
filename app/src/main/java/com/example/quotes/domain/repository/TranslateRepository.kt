package com.example.quotes.domain.repository

import com.example.quotes.common.Resource
import com.example.quotes.domain.model.translate.TranslationModel
import kotlinx.coroutines.flow.Flow

interface TranslateRepository {
    fun getTranslateText(translateText: String): Flow<Resource<List<TranslationModel>>>
}