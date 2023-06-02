package com.example.quotes.domain.usecases

import com.example.quotes.domain.repository.QuoteRepository

class GetQuoteUseCase(private val repository: QuoteRepository) {
    operator fun invoke(category: String) = repository.getQuote(category)
}