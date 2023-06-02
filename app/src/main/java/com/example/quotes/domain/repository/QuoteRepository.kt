package com.example.quotes.domain.repository

import com.example.quotes.common.Resource
import com.example.quotes.domain.model.quote.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun getQuote(category: String): Flow<Resource<List<QuoteModel>>>
}