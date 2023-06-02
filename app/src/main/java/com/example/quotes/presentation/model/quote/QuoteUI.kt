package com.example.quotes.presentation.model.quote

import com.example.quotes.domain.model.quote.QuoteModel

data class QuoteUI(
    val author: String,
    val category: String,
    val quote: String
)

fun QuoteModel.toUI() = QuoteUI(
    author = author,
    category = category,
    quote = quote
)